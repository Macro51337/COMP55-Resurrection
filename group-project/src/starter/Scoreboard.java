package starter;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GRect;
import java.awt.*;
import java.awt.List;
import java.applet.*;
import java.util.*;
import javafx.util.*;
import java.io.*;
import java.util.concurrent.ConcurrentHashMap;

public class Scoreboard extends GraphicsPane{
	private MainApplication program;
	private GParagraph para;
	private String playerName;
	private Pair<String, Integer> scores;
	private ArrayList<Pair<String, Integer>> list;
	private GamePane score;
	private GLabel name = new GLabel("Player Name: "), boardScore = new GLabel("Score:"), highScore = new GLabel("Highscores"), scoreboardName = new GLabel("Input your name: ");
	String saved;
	TextField text;
	private GRect textRect;
	File scoreFile = new File("scores.txt");
	FileWriter out = null;
	FileInputStream in = null;
	
	public Scoreboard(MainApplication app, int currScore) {
		super();
		System.out.println(currScore);
		this.program = app;
		para = new GParagraph("SCOREBOARD", 250, 100);
		para.setFont("ShowcardGothic-50");
		para.setColor(Color.BLUE);
		text = new TextField(20);
		textRect = new GRect(0, 0);
		textRect.setSize(100, 50);
		textRect.setFillColor(Color.WHITE);
		textRect.setFilled(true);
		scoreboardName.setFont("Lato-30");
		scoreboardName.setColor(Color.WHITE);
		playerName = text.getText();
        //scores = new Pair(playerName, score.finalScore());
        //list.add(scores);
        //sortList();
        //saveList();
		/*app.setBackground(Color.BLACK);
		highScore.setColor(Color.WHITE);
		highScore.setFont("Lato-70");
		app.add(highScore, 400, 100);
		
		name.setColor(Color.WHITE);
		name.setFont("Lato-50");
		app.add(name, 200, 200);
		
		highScore.setColor(Color.WHITE);
		highScore.setFont("Lato-50");
		app.add(boardScore, 600, 200);
		
		displayList();
		*/
	}
	
	public void displayList() {
		try {
			Scanner myReader = new Scanner(scoreFile);
		      while ((saved = myReader.nextLine())!= null) {
		        String player = myReader.next();
		        int score = myReader.nextInt();
		        Pair<String, Integer> temp = new Pair(player, score);
		        list.add(temp);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		if(list.size() < 10) {
			int tempNum = 220;
			for(int i = 0; i < list.size(); i++) {
				GLabel tempName = new GLabel(list.get(i).getKey());
				GLabel tempScore = new GLabel(list.get(i).getValue().toString());
				program.add(tempName, 200, tempNum);
				program.add(tempScore, 600, tempNum);
				tempNum+=20;
			}
		}
		else{
			int tempNum = 220;
			for(int i = 0; i < 10; i++) {
				GLabel tempName = new GLabel(list.get(i).getKey());
				GLabel tempScore = new GLabel(list.get(i).getValue().toString());
				program.add(tempName, 200, tempNum);
				program.add(tempScore, 600, tempNum);
				tempNum+=20;
			}
		}
	}
	
	public void saveList() {
		int num = 0;
		try {
			if (scoreFile.createNewFile()) {
				out = new FileWriter(scoreFile);
				while(num != list.size()) {
					out.write(list.get(num).getKey()+ " " + list.get(num).getValue() + "\n");
				}
			}
			else {
				out = new FileWriter("scores.txt");
				while(num != list.size()) {
					out.write(scores.getKey()+ " " + scores.getValue()+ "\n");
				}
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	public void getList() {
		try {
		      Scanner myReader = new Scanner(scoreFile);
		      while ((saved = myReader.nextLine())!= null) {
		        String player = myReader.next();
		        int score = myReader.nextInt();
		        Pair<String, Integer> temp = new Pair(player, score);
		        list.add(temp);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	public void sortList() {
		Pair<String, Integer> temp;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getValue() > list.get(i+1).getValue() ) {
                    temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
	}

	@Override
	public void showContents() {
		// TODO Auto-generated method stub
		program.add(name);
		program.add(para);
		program.add(textRect, 300, 400);
		program.add(scoreboardName, 300, 425);
	}

	@Override
	public void hideContents() {
		// TODO Auto-generated method stub
		program.remove(name);
	}
}


