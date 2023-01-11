package ConsumingAPI.NBAapp;

public class Game {

    String start;          // /date/start
    String HomeTeam;
    String AwayTeam;

    @Override
    public String toString() {
        return "Game{" +
                "start='" + start + '\'' +
                ", HomeTeam='" + HomeTeam + '\'' +
                ", AwayTeam='" + AwayTeam + '\'' +
                ", HomeScore=" + HomeScore +
                ", AwayScore=" + AwayScore +
                '}';
    }

    public Game(String start, String homeTeam, String awayTeam, int homeScore, int awayScore) {
        this.start = start;
        HomeTeam = homeTeam;
        AwayTeam = awayTeam;
        HomeScore = homeScore;
        AwayScore = awayScore;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getHomeTeam() {
        return HomeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        HomeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return AwayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        AwayTeam = awayTeam;
    }

    public int getHomeScore() {
        return HomeScore;
    }

    public void setHomeScore(int homeScore) {
        HomeScore = homeScore;
    }

    public int getAwayScore() {
        return AwayScore;
    }

    public void setAwayScore(int awayScore) {
        AwayScore = awayScore;
    }

    int HomeScore ;
    int AwayScore ;




}
