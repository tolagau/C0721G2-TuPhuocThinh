package _08_clean_code.exercise;

public class TennisGame {
    public static String getScore(String player1Name, String player2Name, int playScore1, int playScore2) {
        String resultScore = "";
        boolean isDeuce = playScore1 == playScore2;
        if (isDeuce) {
            if (playScore1 < 3) {
                resultScore = checkScore(playScore1) + "-All";
            } else {
                resultScore = checkScore(playScore1);
            }
        } else if (playScore1 >= 3 || playScore2 >= 3) {
            int minusResult = playScore1 - playScore2;
            resultScore = check(minusResult);
        } else {
            resultScore = checkScore(playScore1) + "-" + checkScore(playScore2);
        }
        return resultScore;
    }

    public static String check(int minusResult) {
        String resultScore = "";
        if (minusResult == 1)
            resultScore = "Advantage player1";
        else if (minusResult == -1) resultScore = "Advantage player2";
        else if (minusResult >= 2) resultScore = "Win for player1";
        else resultScore = "Win for player2";
        return resultScore;
    }

    public static String checkScore(int playScore) {
        String scoreResult;
        switch (playScore) {
            case 0:
                scoreResult = "Love";
                break;
            case 1:
                scoreResult = "Fifteen";
                break;
            case 2:
                scoreResult = "Thirty";
                break;
            case 3:
                scoreResult = "Forty";
                break;
            default:
                scoreResult = "Deuce";
                break;
        }
        return scoreResult;

    }
}