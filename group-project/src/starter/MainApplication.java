package starter;

public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	public static final int BUTTON_WIDTH = 400;
	public static final int BUTTON_HEIGHT = 75;
	public static final int ROW_ALIENS = 4;
	public static final int COLUMN_ALIENS = 12;
	public static final int TIMER_SPEED = 20; //bigger = slower, smaller = faster
	public static final int ALIEN_MODULUS = 9;
	public static final int LASER_MODULUS = 50;
	public static final int LASER_SPEED = 10; //bigger = faster, smaller = slower
	public static final int SHIP_X = 25;
	public static final int SHIP_Y = 500;
	public static final String MUSIC_FOLDER = "sounds";
	private static final String[] SOUND_FILES = {  "laser.mp3", "bullet.mp3", "somethinlikethis.mp3", "r2d2.mp3" };

	private GamePane gamePane;
	private ExitPane exitPane;
	private WinPane winPane;
	private MenuPane menu;
	private LosePane losePane;
	private Scoreboard scorePane;
	private int count;

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void run() {
		System.out.println("Hello, world!");
		exitPane = new ExitPane(this);
		menu = new MenuPane(this);
		switchToMenu();
	}

	public void switchToWin(int score) {
		winPane = new WinPane(this, score);
		switchToScreen(winPane);
	}
	
	public void switchToLose() {
		losePane = new LosePane(this);
		switchToScreen(losePane);
	}
	
	public void switchToMenu() { //switches to menu screen
		count++;
		switchToScreen(menu);
	}

	public void switchToGame() { //switches to game screen
		gamePane = new GamePane(this);
		switchToScreen(gamePane);
	}
	
	public void switchToScore() {
		switchToScreen(scorePane);
	}
	
	public void switchToExit() { //switches to exit screen
		switchToScreen(exitPane);
	}
	
	public void playAlienLaser() { 
		AudioPlayer audio = AudioPlayer.getInstance(); 
		audio.playSound(MUSIC_FOLDER, SOUND_FILES[0]); 
	}
	
	public void playShipLaser() {
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.playSound(MUSIC_FOLDER, SOUND_FILES[1]);
	}
	
}
