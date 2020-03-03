import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Random random=new Random();
	Rocketship r;
	ArrayList<Alien> aliens=new ArrayList<Alien>();
	ArrayList<Projectile> projectiles=new ArrayList<Projectile>();
	int score=0;
	ObjectManager(Rocketship rocket){
		this.r=rocket;
	}
	void addProjectile(Projectile p) {
		projectiles.add(p);
	}
	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
	}
	void update() {
		for(int i=0;i<aliens.size();i++) {
			aliens.get(i).update();
			if(aliens.get(i).y>LeagueInvaders.HEIGHT) {
				aliens.get(i).isActive=false;
			}
		}
		for(int i=0;i<projectiles.size();i++) {
			projectiles.get(i).update();
			if(projectiles.get(i).y>LeagueInvaders.HEIGHT) {
				projectiles.get(i).isActive=false;
			}
		}
		checkCollision();
		purgeObjects();
	}
	int getScore() {
		return score;
	}
	void draw(Graphics g) {
		r.draw(g);
		for(int i=0;i<aliens.size();i++) {
			aliens.get(i).draw(g);
		}
		for(int i=0;i<projectiles.size();i++) {
			projectiles.get(i).draw(g);
		}
	}
	void purgeObjects() {
		for(int i=0;i<aliens.size();i++) {
			if(aliens.get(i).isActive==false) {
				aliens.remove(i);
			}
		}
		for(int i=0;i<projectiles.size();i++) {
			if(projectiles.get(i).isActive==false) {
				projectiles.remove(i);
			}
		}
	}
	void checkCollision() {
		for(int i=0;i<aliens.size();i++) {
			for(int j=0;j<projectiles.size();j++) {
				
			if(r.collisionBox.intersects(aliens.get(i).collisionBox) ) {
				aliens.get(i).isActive=false;
				r.isActive=false;
			}
			if(projectiles.get(j).collisionBox.intersects(aliens.get(i).collisionBox)) {
				aliens.get(i).isActive=false;
				projectiles.get(j).isActive=false;
				score++;
			}
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}
}
