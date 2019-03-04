package view;

import domain.Card;
import domain.User;
import dto.UserDto;

import java.util.List;

public class ResultView {
    public static void showUserPair(List<Card> cards) {
        System.out.print("당신의 패 : ");
        for (Card card : cards) {
            System.out.print(card + " ");
        }
        System.out.println();
    }

    public static void showWinner(UserDto winnerDto, UserDto loserDto) {
        if (winnerDto.getName().equals("컴퓨터")) {
            System.out.println(loserDto.getName() + "의 패 : " + loserDto.getGenealogy());
            System.out.println(winnerDto.getName() + "의 패 : " + winnerDto.getGenealogy());
            System.out.println("우승자는 " + winnerDto.getName() + "입니다!!");
            return;
        }
        System.out.println(winnerDto.getName() + "의 패 : " + winnerDto.getGenealogy());
        System.out.println(loserDto.getName() + "의 패 : " + loserDto.getGenealogy());
        System.out.println("우승자는 " + winnerDto.getName() + "입니다!!");
    }
}
