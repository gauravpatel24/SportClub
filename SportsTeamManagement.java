import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

class Team {
    private String name;
    private ArrayList<String> players;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    public void addPlayer(String playerName) {
        players.add(playerName);
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getPlayers() {
        return players;
    }
}

class Match {
    private String team1;
    private String team2;
    private LocalDate date;
    private String result;

    public Match(String team1, String team2, LocalDate date) {
        this.team1 = team1;
        this.team2 = team2;
        this.date = date;
        this.result = "Pending";
    }

    public String getMatchInfo() {
        return date + ": " + team1 + " vs " + team2 + " - Result: " + result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean involvesTeam(String team) {
        return team1.equalsIgnoreCase(team) || team2.equalsIgnoreCase(team);
    }

    public boolean involvesPlayer(String player, Team t1, Team t2) {
        return t1.getPlayers().contains(player) || t2.getPlayers().contains(player);
    }

    public LocalDate getDate() {
        return date;
    }
}

public class SportsTeamManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name of Team A: ");
        String teamAName = scanner.nextLine();
        Team teamA = new Team(teamAName);

        System.out.print("Enter number of players in " + teamAName + ": ");
        int numPlayersA = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numPlayersA; i++) {
            System.out.print("Enter player " + (i + 1) + " name: ");
            teamA.addPlayer(scanner.nextLine());
        }

        System.out.print("\nEnter name of Team B: ");
        String teamBName = scanner.nextLine();
        Team teamB = new Team(teamBName);

        System.out.print("Enter number of players in " + teamBName + ": ");
        int numPlayersB = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numPlayersB; i++) {
            System.out.print("Enter player " + (i + 1) + " name: ");
            teamB.addPlayer(scanner.nextLine());
        }

        System.out.print("\nEnter match date (YYYY-MM-DD): ");
        String dateStr = scanner.nextLine();
        LocalDate matchDate = LocalDate.parse(dateStr);

        Match match = new Match(teamAName, teamBName, matchDate);

        System.out.println("\nMatch Info:");
        System.out.println(match.getMatchInfo());

        System.out.print("\nEnter player name to check if involved: ");
        String checkPlayer = scanner.nextLine();
        boolean involved = match.involvesPlayer(checkPlayer, teamA, teamB);
        System.out.println("Is " + checkPlayer + " playing? " + involved);

        System.out.print("\nEnter match result: ");
        String result = scanner.nextLine();
        match.setResult(result);

        System.out.println("\nFinal Match Info:");
        System.out.println(match.getMatchInfo());

        scanner.close();
    }
}