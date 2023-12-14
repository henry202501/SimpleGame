 1. Init player
 2. Loop spin play
    - Check balance
    - Best result (Control win, loss by rpt)
       + DEEP_CONTROL_WIN = 1000
       + DEEP_CONTROL_LOSS= 10
       + RTP = 90
    - Open win by result
 3. Test case
   Loop 3: Balance = 100, run 100
   Loop 3: Balance = 100, run 200
   Loop 3: Balance = 500, run 100
   Loop 3: Balance = 500, run 200

   Same rtp: 90%
 
   Result  in: Test_result.txt
    
      
