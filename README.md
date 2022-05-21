# SportRadarLibrary

[![Java CI with Maven](https://github.com/Dobias1/SportRadarLibrary/actions/workflows/maven.yml/badge.svg)](https://github.com/Dobias1/SportRadarLibrary/actions/workflows/maven.yml)

SportRadarLibrary is a Java library for storing and displaying scores of running games. Details are provided
in [Coding Exercise v1.5.pdf]([https://](https://github.com/Dobias1/SportRadarLibrary/Coding%20Exercise%20v1.5.pdf))

## Installation

Use the build tool [Maven](https://maven.apache.org/) to install SportRadarLibrary.

```bash
mvn install -f pom.xml
```

## Usage

```java
import com.dobias1.SportRadarLibrary;

public class BoardCaller {
    FootballWorldCupScoreBoard board = FootballWorldCupScoreBoardFactory.createFootballWorldCupScoreBoard();

    public static void main(String[] args) {
        // starts new match
        board.startMatch(new Match("TeamA", "TeamB"));

        // changes scores
        board.updateScore(board.getMatche(0), 1, 0);

        // finishes the 1. match
        board.finishMatch(0);

        // shows summary of all games
        board.getSummary();
    }
}
```

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

Write [nice](https://chris.beams.io/posts/git-commit/) commit messages.

## License

[MIT](https://choosealicense.com/licenses/mit/)
