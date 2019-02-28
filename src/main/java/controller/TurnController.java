package controller;

import view.InputView;

public class TurnController {
    private static final int MAX_TURN = 5;
    
    public static void userTurn(){
        BettingController.bet()

        int battingType = InputView.selectGameType();
        if(battingType==1){
            //다이
        }
        if(battingType==2){
            //콜
        }
        if(battingType==3){
            computerTurn();
        }
        //...
    }
}
