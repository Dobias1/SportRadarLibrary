# SportRadarLibrary

[![Java CI with Maven](https://github.com/Dobias1/SportRadarLibrary/actions/workflows/maven.yml/badge.svg)](https://github.com/Dobias1/SportRadarLibrary/actions/workflows/maven.yml)

SportRadarLibrary is a Java library for storing and displaying scores of running games. Details are provided
in [Coding Exercise v1.5.pdf]([https://](https://github.com/Dobias1/SportRadarLibrary/Coding%20Exercise%20v1.5.pdf))

## Installation

Use the build tool [Maven](https://maven.apache.org/) to install SportRadarLibrary.

```bash
mvn source:jar install --file pom.xml
```

## Usage

```java
package org.example;

import com.dobias1.FootballWorldCupScoreBoard;
import com.dobias1.FootballWorldCupScoreBoardFactory;
import com.dobias1.Match;

public class App {
    static FootballWorldCupScoreBoard board = FootballWorldCupScoreBoardFactory.createFootballWorldCupScoreBoard();

    public static void main(String[] args) {

        // starts new matches
        Match firstMatch = new Match("TeamA", "TeamB");
        Match secondMatch = new Match("TeamC", "TeamD");
        board.startMatch(firstMatch);
        board.startMatch(secondMatch);
        // 1. TeamA 0 - TeamB 0
        // 2. TeamC 0 - TeamD 0
        System.out.println(board.getSummary());

        // changes scores
        board.updateScore(0, 5, 10);
        board.updateScore(1, 5, 15);
        // Summary order is by sum of scores
        // 1. TeamC 5 - TeamD 15
        // 2. TeamA 5 - TeamB 10
        System.out.println(board.getSummary());

        // finishes the 1. match
        board.finishMatch(firstMatch);

        // shows summary of all remaining games
        // 1. TeamC 5 - TeamD 15
        System.out.println(board.getSummary());
    }
}
```

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

Write [nice](https://chris.beams.io/posts/git-commit/) commit messages.

## License

[MIT](https://choosealicense.com/licenses/mit/)
