import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.print.Printable;
import java.time.Year;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Shoot_ball extends JFrame {

	ImageIcon shoot = new ImageIcon("img/shoot.png");
	ImageIcon shoot1 = new ImageIcon("img/shoot1.png");
	ImageIcon football = new ImageIcon("img/football.png");
	ImageIcon baseball = new ImageIcon("img/baseball.png");
	ImageIcon bowling = new ImageIcon("img/bowling.png");
	ImageIcon billiardball = new ImageIcon("img/billiardball.png");
	ImageIcon volleyball = new ImageIcon("img/volleyball.png");
	ImageIcon basketball = new ImageIcon("img/basketball.png");
	ImageIcon Golf = new ImageIcon("img/Golf.png");
	ImageIcon tennis = new ImageIcon("img/tennis.png");
	ImageIcon two = new ImageIcon("img/2.png");
	ImageIcon one = new ImageIcon("img/1.png");
	ImageIcon three = new ImageIcon("img/3.png");
	ImageIcon time = new ImageIcon("img/timer.png");
	ImageIcon Scoreboard = new ImageIcon("img/Scoreboard.png");
	ImageIcon golfcourse = new ImageIcon("img/golf course.png");
	ImageIcon footballfield = new ImageIcon("img/football field.png");
	ImageIcon tenniscourt = new ImageIcon("img/tennis court.png");
	ImageIcon Basketballcourt = new ImageIcon("img/Basketball court.png");
	ImageIcon Bowlinglane = new ImageIcon("img/Bowling lane.png");
	ImageIcon Baseballfield = new ImageIcon("img/Baseball field.png");
	ImageIcon Pooltable = new ImageIcon("img/Pooltable.png");
	ImageIcon Volleyballcourt = new ImageIcon("img/Volleyball court.png");
	
	
	ImageIcon[] ball = new ImageIcon[10000];

	int golfcourse_y;
	int footballfield_y;
	int tenniscourt_y;
	int Basketballcourt_y;
	int Bowlinglane_y;
	int Baseballfield_y;
	int Pooltable_y;
	int Volleyballcourt_y;
	int shootL_t;
	int shootM_t;
	int shootR_t;
	int jump_t;
	int down_t;
	int ball_id;
	int scoring_t;
	int t;
	int Game_t;
	int Score;
	int player = 0;
	int[] ball_x = new int[1000];
	int[] ball_y = new int[1000];
	int[] rank=  new int[100];
	
	
	
	boolean open_jump;
	boolean open_down;
	boolean open_shootL_t;
	boolean open_shootM_t;
	boolean open_shootR_t;
	boolean isStart;
	boolean isEnd;
	boolean open_Game;
	boolean open_Scoring;

	Timer timer = new Timer();
	Random random = new Random();

	public static void main(String[] args) {
		Shoot_ball shoot_ball = new Shoot_ball();
	}

	public Shoot_ball() {
		Frame();

		Panel panel = new Panel();
		this.add(panel);

		Action action = new Action();
		this.addKeyListener(action);

		this.setFocusable(true);

		init_ball();

		timer.schedule(new Timertask(), 0, 10);
	}

	void Frame() {
		this.setTitle("Shoot ball");
		int w = 500;
		int h = 750;
		this.setSize(w, h);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setResizable(true);

		int sw = Toolkit.getDefaultToolkit().getScreenSize().width;
		int sh = Toolkit.getDefaultToolkit().getScreenSize().height;

		this.setLocation((sw - w) / 2, (sh - h) / 2);

		this.setVisible(true);

	}

	void init_ball() {
		shootL_t = 0;
		shootM_t = 0;
		shootR_t = 0;
		jump_t = 0;
		down_t = 0;
		scoring_t = 0;
		t = 0;
		Game_t = 0;
		ball_id = 0;
		Score = 0;

		
		golfcourse_y = 0;
		footballfield_y=-710;
		tenniscourt_y=-710;
		Basketballcourt_y=-710;
		Bowlinglane_y=-710;
		Baseballfield_y=-710;
		Pooltable_y=-710;
		Volleyballcourt_y=-710;	
		
		player++;
		Arrays.sort(rank);

		open_shootL_t = false;
		open_shootM_t = false;
		open_shootR_t = false;
		open_down = false;
		open_jump = false;
		open_Game = false;
		
		isStart =false;
		isEnd =false;

		ball_x = new int[1000];
		ball_y = new int[1000];
		ball = new ImageIcon[1000];

		ball_x[0] = random.nextInt(3) * 150 + 50;
		ball_x[1] = random.nextInt(3) * 150 + 50;
		ball_x[2] = random.nextInt(3) * 150 + 50;
		ball_x[3] = random.nextInt(3) * 150 + 50;
		ball_x[4] = random.nextInt(3) * 150 + 50;

		ball_y[0] = 470;
		ball_y[1] = 350;
		ball_y[2] = 230;
		ball_y[3] = 110;
		ball_y[4] = -10;
		
		ball[0] = Golf;
		ball[1] = Golf;
		ball[2] = Golf;
		ball[3] = Golf;
		ball[4] = Golf;
	}

	void down() {
		for (int i = ball_id; i <= ball_id + 4; i++) {
			ball_y[i] +=120;
		}
		
		ball_id++;
		
		ball_x[ball_id+4] = random.nextInt(3) * 150 + 50;
		
		int open_Golf = 30;
		int open_bowling = 65;
		int open_billiardball=90;
		int open_tennis=120;
		int open_baseball=150;
		int open_football=190;
		int open_volleyball=235;
		
		if (ball_id+4 <= open_Golf) {
			ball[ball_id+4]=Golf;
			
		}else if (ball_id+4 <= open_bowling) {
			ball[ball_id+4]=bowling;
			
			if (ball_id <= open_Golf+1) {
				golfcourse_y +=142;
				Bowlinglane_y +=142;
			}
		}
		else if (ball_id+4 <= open_billiardball) {
			ball[ball_id+4]=billiardball;
			
			if (ball_id <= open_bowling+1) {
				Bowlinglane_y +=142;
				Pooltable_y +=142;
			}
			
		}else if (ball_id+4 <= open_tennis) {
			ball[ball_id+4]=tennis;
			
			if (ball_id <= open_billiardball+1) {
				Pooltable_y +=142;
				tenniscourt_y +=142;
			}
			
			
		}else if (ball_id+4 <= open_baseball) {
			ball[ball_id+4]=baseball;
			
			if (ball_id <= open_tennis+1) {
				Baseballfield_y +=142;
				tenniscourt_y +=142;
			}
			
		}else if (ball_id+4 <= open_football){
			ball[ball_id+4]=football;
			
			if (ball_id <= open_baseball+1) {
				Baseballfield_y +=142;
				footballfield_y +=142;
			}
			
		}else if (ball_id+4 <= open_volleyball){
			ball[ball_id+4] = volleyball;
			
			if (ball_id <= open_football+1) {
				footballfield_y +=142;
				Volleyballcourt_y +=142;
			}
		}else {
			ball[ball_id+4] = basketball;
			
			if (ball_id <= open_volleyball+1) {
				Basketballcourt_y +=142;
				Volleyballcourt_y +=142;
			}
		}
		
		
	}

	class Panel extends JPanel {
		public Panel() {
			setBackground(Color.decode("#8395a7"));
			
		}

		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);

			golfcourse.paintIcon(this, g, 0, golfcourse_y);
			Bowlinglane.paintIcon(this, g, 0, Bowlinglane_y);
			footballfield.paintIcon(this, g, -20, footballfield_y);
			tenniscourt.paintIcon(this, g, -10, tenniscourt_y);
			Basketballcourt.paintIcon(this, g, 0, Basketballcourt_y);
			
			Baseballfield.paintIcon(this, g, 0, Baseballfield_y);
			Pooltable.paintIcon(this, g, 0, Pooltable_y);
			Volleyballcourt.paintIcon(this, g, 0, Volleyballcourt_y);
			
			
			if (open_shootL_t) {
				shoot1.paintIcon(this, g, 30, 575);
				shootL_t++;

				if (shootL_t == 10) {
					open_shootL_t = false;
					shootL_t = 0;
				}
			} else {
				shoot.paintIcon(this, g, 30, 575);
			}

			if (open_shootM_t) {
				shoot1.paintIcon(this, g, 180, 575);

				shootM_t++;

				if (shootM_t == 10) {
					open_shootM_t = false;
					shootM_t = 0;
				}
			} else {
				shoot.paintIcon(this, g, 180, 575);
			}

			if (open_shootR_t) {
				shoot1.paintIcon(this, g, 330, 575);

				shootR_t++;

				if (shootR_t == 10) {
					open_shootR_t = false;
					shootR_t = 0;
				}
			} else {
				shoot.paintIcon(this, g, 330, 575);
			}
	
			if (t >= 100 || open_Game) {
				ball[ball_id+4].paintIcon(this, g, ball_x[ball_id + 4], ball_y[ball_id + 4]);
				ball[ball_id+3].paintIcon(this, g, ball_x[ball_id + 3], ball_y[ball_id + 3]);
				ball[ball_id+2].paintIcon(this, g, ball_x[ball_id + 2], ball_y[ball_id + 2]);
				ball[ball_id+1].paintIcon(this, g, ball_x[ball_id + 1], ball_y[ball_id + 1]);
				ball[ball_id].paintIcon(this, g, ball_x[ball_id], ball_y[ball_id]);// 120
				
			}
			
			if (open_Game && Game_t >0) {
				Game_t --;
			}
			
			if (Game_t == 0 && open_Game) {
				open_Scoring = true;
				scoring_t++;
			}
			
			if (scoring_t == 1) {
				Score = ball_id*314*10;
				rank[player] = Score;
				
				Arrays.sort(rank);
				
			}
			
			if (Game_t == 0 && open_Game) {
				
			    Scoreboard.paintIcon(this, g, 20, 90);
			    g.setColor(Color.black);
			    g.setFont(new Font("微軟正黑體", Font.BOLD, 50));
			    g.drawString(Score + "", 157, 190);
			
			    g.setColor(Color.black);
			    g.setFont(new Font("微軟正黑體", Font.BOLD, 30));
			    
			    g.drawString(rank[99] + "", 200, 343);
			    g.drawString(rank[98] + "", 200, 418);
			    g.drawString(rank[97] + "", 200, 493);
			    g.drawString(rank[96] + "", 200, 568);
			    g.drawString(rank[95] + "", 200, 643);
			    
			}
			
			g.setColor(Color.white);
		    g.setFont(new Font("微軟正黑體", Font.BOLD, 50));
		    //g.drawString(ball_id + "", 335, 100);
		    
		    time.paintIcon(this, g, 5, 5);
		    
		    if (Game_t == 0 && open_Game) {
		    	g.setColor(Color.white);
			    g.setFont(new Font("微軟正黑體", Font.BOLD, 35));
		    	g.drawString(0 + "", 50, 62);
		    }else if (open_Game && Game_t/100+1 >= 10) {
		    	g.setColor(Color.white);
			    g.setFont(new Font("微軟正黑體", Font.BOLD, 35));
		    	g.drawString(Game_t/100+1 + "", 40, 62);
			}else if (open_Game) {
				g.setColor(Color.white);
			    g.setFont(new Font("微軟正黑體", Font.BOLD, 35));
		    	g.drawString(Game_t/100+1 + "", 50, 62);
			}
		    
		    
		    
		    
		    if (open_jump) {
		    	
		    	if (ball_id <= 60) {
		    		
		    		ball_y[ball_id] -=10;
			    	jump_t ++;
			    	
			    	if (jump_t ==10) {
			    		open_down = true;
			    		open_jump = false;
			    		jump_t = 0;
			    	}
			    	
		    	}else if(ball_id <= 120) {
		    		ball_y[ball_id] -=7;
			    	jump_t ++;
			    	
			    	if (jump_t == 18) {
			    		open_down = true;
			    		open_jump = false;
			    		jump_t = 0;
			    	}
		    	}else if (ball_id <=180) {
		    		ball_y[ball_id] -=5;
			    	jump_t ++;
			    	
			    	if (jump_t == 26) {
			    		open_down = true;
			    		open_jump = false;
			    		jump_t = 0;
			    	}
				}else {
					ball_y[ball_id] -=4;
			    	jump_t ++;
			    	
			    	if (jump_t == 34) {
			    		open_down = true;
			    		open_jump = false;
			    		jump_t = 0;
			    	}
				}
		    	
		    	//------------------------------
		    	
		    	
		    }
		    
		    if (open_down ) {
		    	
		    	if (ball_id <=60) {
		    		
		    		ball_y[ball_id] +=10;
			    	down_t ++;
			    	
			    	if (down_t == 10) {
			    		open_down = false;
			    		down_t = 0;
			    	}
			    	
		    	}else if (ball_id <=120) {
		    		ball_y[ball_id] +=7;
			    	down_t ++;
			    	
			    	if (down_t == 18) {
			    		open_down = false;
			    		down_t = 0;
			    	}
				}else if (ball_id <=180) {
					ball_y[ball_id] +=5;
			    	down_t ++;
			    	
			    	if (down_t == 26) {
			    		open_down = false;
			    		down_t = 0;
			    	}
				}else {
					ball_y[ball_id] +=4;
			    	down_t ++;
			    	
			    	if (down_t == 34) {
			    		open_down = false;
			    		down_t = 0;
			    	}
				}
		    }
			
		    if (!isStart) {
		    	g.setColor(Color.white);
			    g.setFont(new Font("微軟正黑體", Font.BOLD, 30));
			    g.drawString("Press Enter to Start !", 95, 350);	
		    }
		    
		    
		    if (t <= 50 && !open_Game && isStart) {
		    	three.paintIcon(this, g, 175, 175);
		    	t++;
		    }else if (t <= 100 && !open_Game && isStart) {
		    	two.paintIcon(this, g, 175, 175);
		    	t++;
		    }else if (!open_Game && isStart) {
		    	one.paintIcon(this, g, 175, 175);
		    	t++;
		    	
		    	
		    	if (t== 150) {
		    		t = 0;
		    		open_Game = true;
		    		Game_t = 3000;
		    	}
			}
		    
		    
		    
			
		}

	}

	class Timertask extends TimerTask {

		@Override
		public void run() {
			//if (isStart && !isEnd) {
				repaint();
			//}
			

		}

	}

	class Action implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub

			int keycode = e.getKeyCode();

			if (keycode == KeyEvent.VK_ENTER && !isStart) {
				isStart = true;
				t = 0;
			}
			
			if (Game_t == 0 && open_Game && keycode == KeyEvent.VK_ENTER) {
				isEnd = true;
				
			}
			
			if (keycode == KeyEvent.VK_SPACE) {
				init_ball();
			}
			
			
			if (isEnd) {
				init_ball();
			}
			
			
			if (open_Game && Game_t > 0) {
				boolean L = keycode == KeyEvent.VK_A || keycode == KeyEvent.VK_LEFT || keycode == KeyEvent.VK_J;
				boolean M = keycode == KeyEvent.VK_S || keycode == KeyEvent.VK_DOWN || keycode == KeyEvent.VK_K;
				boolean R = keycode == KeyEvent.VK_D || keycode == KeyEvent.VK_RIGHT || keycode == KeyEvent.VK_L;

				if (L && !open_jump && !open_down) {
					open_shootL_t = true;

					if (ball_x[ball_id] == 50) {
						down();
					}else {
						open_jump = true;
					}
				}
				if (M && !open_jump && !open_down) {
					open_shootM_t = true;

					if (ball_x[ball_id] == 200) {
						down();
					}else {
						open_jump = true;
					}
				}
				if (R && !open_jump && !open_down) {
					open_shootR_t = true;

					if (ball_x[ball_id] == 350) {
						down();
					}else {
						open_jump = true;
					}
				}
				
				
			}
			
		

		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

	}

}
