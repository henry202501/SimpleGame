package com.game;

import java.util.Arrays;
import java.util.Random;


/*
 * Return To Player = (wins sum/bets sum) X 100%
 */
public class SimpleGame {

	public static void main(String[] args) {
		for (int j = 1; j <3; j++) {
			System.out.println(" Run test case :" +j);
			// 1. Init player
			Player player = new Player();
			player.setName("Test01");
			player.setBalance(100);
			// 2. Loop spin play
			for (int i = 0; i < 100; i++) {
				// Check balance
				if (player.getBalance() <= 0) {
					System.out.println("You don't have enough balance");
					break;
				}
				player.setTotalBet(player.getTotalBet() + 1);
				// Best result
				int[] result = new int[] {};
				double winCredit = 0d;
				if (player.getRtp() > Constants.RTP) {
					// random n result, control player loss
					result = bestWinCredit(ControlWinlossEnum.LOSS);
				} else {
					// random n result, control player win
					result = bestWinCredit(ControlWinlossEnum.WIN);
				}

				// Open win
				winCredit = winCredit(result);
				if (winCredit > 0) {
					player.setBalance(player.getBalance() + 1);
					player.setWin(player.getWin() + 2);

				} else {
					player.setBalance(player.getBalance() - 1);
				}

				Double rtp = player.getWin()*100 / player.getTotalBet();
				player.setRtp(rtp);
				
				String resultMsg = String.format(
						"Turn:%d, Result: %s, winCredit :%f, balance: %f, win: %f, totalBet: %f, rpt: %f", i,
						Arrays.toString(result), winCredit,  player.getBalance(), player.getWin(), player.getTotalBet(),
						player.getRtp());
				System.out.println(resultMsg);

			}
		}
	}

	private static int[] bestWinCredit(ControlWinlossEnum controlWinlossEnum) {

		int[] bestWinResult = buildRowResult();
		double bestWinCredit = winCredit(bestWinResult);
		switch (controlWinlossEnum) {
		case WIN:
			for (int i = 1; i < Constants.DEEP_CONTROL_WIN; i++) {
				int[] currWinResult = buildRowResult();
				double currWinCredit = winCredit(currWinResult);
				if (currWinCredit > bestWinCredit) {
					bestWinCredit = currWinCredit;
					bestWinResult = currWinResult;
				}
			}
			break;
		case LOSS:
			for (int i = 1; i < Constants.DEEP_CONTROL_LOSS; i++) {
				int[] currWinResult = buildRowResult();
				double currWinCredit = winCredit(currWinResult);
				if (currWinCredit < bestWinCredit) {
					bestWinCredit = currWinCredit;
					bestWinResult = currWinResult;
				}
			}
			break;
		}
		return bestWinResult;

	}

	private static double winCredit(int[] result) {
		if (Arrays.stream(result).allMatch(s -> s == result[0])) {
			return 1;
		} else {
			return 0;
		}
	}

	private static int[] buildRowResult() {
		int[] result = new int[] { buildCellResult(), buildCellResult(), buildCellResult() };
		return result;
	}

	private static int buildCellResult() {
		int value = new Random().nextInt(10);
		return value;
	}

}
