package netInvaders2;

    public class Bomb extends Bullet {
    	public static final int UP_LEFT = 0;
    	public static final int UP = 1;
    	public static final int UP_RIGHT = 2;
    	public static final int LEFT = 3;
    	public static final int RIGHT = 4;
    	public static final int DOWN_LEFT = 5;
    	public static final int DOWN = 6;
    	public static final int DOWN_RIGHT = 7;

    	protected static final int BOMB_SPEED = 10; 
    	protected int vx;
    	protected int vy;

    	
 
    	 
    	 
    	public Bomb(Stage stage, int heading, int x, int y,int nJugador) {
    		super(stage);
    		jugadorDispara=nJugador;
    		this.x = x;
    		this.y = y;
    		String sprite ="";
    		switch (heading) {
    			case UP_LEFT : vx = -BOMB_SPEED; vy = -BOMB_SPEED; sprite="disparos/bomb/bombUL.gif";break;
    			case UP : vx = 0; vy = -BOMB_SPEED; sprite="disparos/bomb/bombU.gif";break;
    			case UP_RIGHT: vx = BOMB_SPEED; vy = -BOMB_SPEED; sprite="disparos/bomb/bombUR.gif";break;
    			case LEFT : vx = -BOMB_SPEED; vy = 0; sprite = "disparos/bomb/bombL.gif";break;
    			case RIGHT : vx = BOMB_SPEED; vy = 0; sprite = "disparos/bomb/bombR.gif";break;
    			case DOWN_LEFT : vx = -BOMB_SPEED; vy = BOMB_SPEED; sprite="disparos/bomb/bombDL.gif";break;
    			case DOWN : vx = 0; vy = BOMB_SPEED; sprite = "disparos/bomb/bombD.gif";break;
    			case DOWN_RIGHT : vx = BOMB_SPEED; vy = BOMB_SPEED; sprite = "disparos/bomb/bombDR.gif";break;
    		}   
    		setSpriteNames( new String[] {sprite});
    	}

    	public void act() {
    		super.act();
    		y+=vy;
    		x+=vx;
    		if (y < 0 || y > Stage.HEIGHT || x < 0 || x > Stage.WIDTH)
    			remove();
    	}
    	
    	
    	public int getJugador() {   return jugadorDispara; }

    	public void collision(Actor a) {
    		if (a instanceof Monster || a instanceof JefeFinal) {
    			remove();
    		}
    		  
    	} 
    }