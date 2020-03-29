package Interface;

import java.awt.*;
import javax.swing.*;
import java.util.*;

import Plateau.*;

/**
 * Classe pour l'interface de jeu
 * 
 * @author Clément RUER, Romain MIGNAC
 */
public class Dessin extends JComponent implements Observer {

	private Point centre;
	private int rayon;

	private Plateau p;

	public Dessin(Plateau p) {

		this.p = p;
		repaint();
	}

	@Override
	public void update(Observable o, Object data) {

		this.p = (Plateau) data;
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {

		centre = new Point(this.getWidth() / 2, this.getHeight() / 2);
		rayon = this.getWidth() < this.getHeight() ? this.getWidth() / 6 : this.getHeight() / 6;
		double rac2sur2 = 0.70710678118;
		double rac3sur2 = 0.86602540378;

		g.setColor(Color.ORANGE);
		g.fillOval(getCentre().x - 2 * getRayon(), getCentre().y - 2 * getRayon(), 2 * 2 * getRayon(),
				2 * 2 * getRayon());
		g.fillOval(getCentre().x - 3 * getRayon(), getCentre().y - 3 * getRayon(), 2 * 3 * getRayon(),
				2 * 3 * getRayon());

		g.setColor(Color.GREEN);
		g.fillOval(getCentre().x - getRayon(), getCentre().y - getRayon(), 2 * getRayon(), 2 * getRayon());

		g.setColor(Color.BLACK);
		g.drawOval(getCentre().x - 2 * getRayon(), getCentre().y - 2 * getRayon(), 2 * 2 * getRayon(),
				2 * 2 * getRayon());
		g.drawOval(getCentre().x - 3 * getRayon(), getCentre().y - 3 * getRayon(), 2 * 3 * getRayon(),
				2 * 3 * getRayon());
		g.drawOval(getCentre().x - getRayon(), getCentre().y - getRayon(), 2 * getRayon(), 2 * getRayon());

		/* EN 4 */

		g.drawLine(getCentre().x - 3 * getRayon(), getCentre().y, getCentre().x + 3 * getRayon(), getCentre().y);
		g.drawLine(getCentre().x, getCentre().y - 3 * getRayon(), getCentre().x, getCentre().y + 3 * getRayon());

		/* EN 8 */
		g.drawLine(getCentre().x + (int) (rac2sur2 * getRayon()), getCentre().y + (int) (rac2sur2 * getRayon()),
				getCentre().x + (int) (2 * rac2sur2 * getRayon()), getCentre().y + (int) (2 * rac2sur2 * getRayon()));
		g.drawLine(getCentre().x - (int) (rac2sur2 * getRayon()), getCentre().y - (int) (rac2sur2 * getRayon()),
				getCentre().x - (int) (2 * rac2sur2 * getRayon()), getCentre().y - (int) (2 * rac2sur2 * getRayon()));
		g.drawLine(getCentre().x + (int) (rac2sur2 * getRayon()), getCentre().y - (int) (rac2sur2 * getRayon()),
				getCentre().x + (int) (2 * rac2sur2 * getRayon()), getCentre().y - (int) (2 * rac2sur2 * getRayon()));
		g.drawLine(getCentre().x - (int) (rac2sur2 * getRayon()), getCentre().y + (int) (rac2sur2 * getRayon()),
				getCentre().x - (int) (2 * rac2sur2 * getRayon()), getCentre().y + (int) (2 * rac2sur2 * getRayon()));

		/* EN 12 */

		g.drawLine(getCentre().x + (int) (2 * rac3sur2 * getRayon()), getCentre().y + (int) (2 * getRayon() / 2),
				getCentre().x + (int) (3 * rac3sur2 * getRayon()), getCentre().y + (int) (3 * getRayon() / 2));

		g.drawLine(getCentre().x - (int) (2 * rac3sur2 * getRayon()), getCentre().y - (int) (2 * getRayon() / 2),
				getCentre().x - (int) (3 * rac3sur2 * getRayon()), getCentre().y - (int) (3 * getRayon() / 2));

		g.drawLine(getCentre().x + (int) (2 * rac3sur2 * getRayon()), getCentre().y - (int) (2 * getRayon() / 2),
				getCentre().x + (int) (3 * rac3sur2 * getRayon()), getCentre().y - (int) (3 * getRayon() / 2));

		g.drawLine(getCentre().x - (int) (2 * rac3sur2 * getRayon()), getCentre().y + (int) (2 * getRayon() / 2),
				getCentre().x - (int) (3 * rac3sur2 * getRayon()), getCentre().y + (int) (3 * getRayon() / 2));

		g.drawLine(getCentre().x + (int) (2 * getRayon() / 2), getCentre().y + (int) (2 * rac3sur2 * getRayon()),
				getCentre().x + (int) (3 * getRayon() / 2), getCentre().y + (int) (3 * rac3sur2 * getRayon()));

		g.drawLine(getCentre().x - (int) (2 * getRayon() / 2), getCentre().y - (int) (2 * rac3sur2 * getRayon()),
				getCentre().x - (int) (3 * getRayon() / 2), getCentre().y - (int) (3 * rac3sur2 * getRayon()));

		g.drawLine(getCentre().x - (int) (2 * getRayon() / 2), getCentre().y + (int) (2 * rac3sur2 * getRayon()),
				getCentre().x - (int) (3 * getRayon() / 2), getCentre().y + (int) (3 * rac3sur2 * getRayon()));

		g.drawLine(getCentre().x + (int) (2 * getRayon() / 2), getCentre().y - (int) (2 * rac3sur2 * getRayon()),
				getCentre().x + (int) (3 * getRayon() / 2), getCentre().y - (int) (3 * rac3sur2 * getRayon()));

		/* Zone1 */
		drawEmplacement(g, getCentre().x + (getRayon() / 8), getCentre().y + (getRayon() / 6), 2 * getRayon() / 4,
				getRayon() / 3, p.getZone(1).getCase(1));
		drawEmplacement(g, getCentre().x + (getRayon() / 8), getCentre().y - (getRayon() / 6) - getRayon() / 3,
				2 * getRayon() / 4, getRayon() / 3, p.getZone(1).getCase(0));
		drawEmplacement(g, getCentre().x - (getRayon() / 8) - 2 * (getRayon() / 4),
				getCentre().y - (getRayon() / 6) - getRayon() / 3, 2 * getRayon() / 4, getRayon() / 3,
				p.getZone(1).getCase(3));
		drawEmplacement(g, getCentre().x - (getRayon() / 8) - 2 * (getRayon() / 4), getCentre().y + (getRayon() / 6),
				2 * getRayon() / 4, getRayon() / 3, p.getZone(1).getCase(2));

		/* Zone2 */
		drawEmplacement(g, getCentre().x + (getRayon() / 8 + getRayon()), getCentre().y + (getRayon() / 6),
				2 * getRayon() / 4, getRayon() / 3, p.getZone(2).getCase(2));
		drawEmplacement(g, getCentre().x + (getRayon() / 8 + getRayon()),
				getCentre().y - (getRayon() / 6) - getRayon() / 3, 2 * getRayon() / 4, getRayon() / 3,
				p.getZone(2).getCase(1));
		drawEmplacement(g, getCentre().x - (getRayon() / 8 + getRayon()) - 2 * (getRayon() / 4),
				getCentre().y - (getRayon() / 6) - getRayon() / 3, 2 * getRayon() / 4, getRayon() / 3,
				p.getZone(2).getCase(6));
		drawEmplacement(g, getCentre().x - (getRayon() / 8 + getRayon()) - 2 * (getRayon() / 4),
				getCentre().y + (getRayon() / 6), 2 * getRayon() / 4, getRayon() / 3, p.getZone(2).getCase(5));

		drawEmplacement(g, getCentre().x + (getRayon() / 8), getCentre().y + (getRayon() / 6 + getRayon()),
				2 * getRayon() / 4, getRayon() / 3, p.getZone(2).getCase(3));
		drawEmplacement(g, getCentre().x + (getRayon() / 8),
				getCentre().y - (getRayon() / 6 + getRayon()) - getRayon() / 3, 2 * getRayon() / 4, getRayon() / 3,
				p.getZone(2).getCase(0));
		drawEmplacement(g, getCentre().x - (getRayon() / 8) - 2 * (getRayon() / 4),
				getCentre().y - (getRayon() / 6 + getRayon()) - getRayon() / 3, 2 * getRayon() / 4, getRayon() / 3,
				p.getZone(2).getCase(7));
		drawEmplacement(g, getCentre().x - (getRayon() / 8) - 2 * (getRayon() / 4),
				getCentre().y + (getRayon() / 6 + getRayon()), 2 * getRayon() / 4, getRayon() / 3,
				p.getZone(2).getCase(4));

		/* Zone3 */
		drawEmplacement(g, getCentre().x + (getRayon() / 8 + 2 * getRayon()), getCentre().y + (getRayon() / 6),
				2 * getRayon() / 4, getRayon() / 3, p.getZone(3).getCase(3));
		drawEmplacement(g, getCentre().x + (getRayon() / 8 + 2 * getRayon()),
				getCentre().y - (getRayon() / 6) - getRayon() / 3, 2 * getRayon() / 4, getRayon() / 3,
				p.getZone(3).getCase(2));
		drawEmplacement(g, getCentre().x - (getRayon() / 8 + 2 * getRayon()) - 2 * (getRayon() / 4),
				getCentre().y - (getRayon() / 6) - getRayon() / 3, 2 * getRayon() / 4, getRayon() / 3,
				p.getZone(3).getCase(9));
		drawEmplacement(g, getCentre().x - (getRayon() / 8 + 2 * getRayon()) - 2 * (getRayon() / 4),
				getCentre().y + (getRayon() / 6), 2 * getRayon() / 4, getRayon() / 3, p.getZone(3).getCase(8));

		drawEmplacement(g, getCentre().x + (getRayon() / 8), getCentre().y + (getRayon() / 6 + 2 * getRayon()),
				2 * getRayon() / 4, getRayon() / 3, p.getZone(3).getCase(5));
		drawEmplacement(g, getCentre().x + (getRayon() / 8),
				getCentre().y - (getRayon() / 6 + 2 * getRayon()) - getRayon() / 3, 2 * getRayon() / 4, getRayon() / 3,
				p.getZone(3).getCase(0));
		drawEmplacement(g, getCentre().x - (getRayon() / 8) - 2 * (getRayon() / 4),
				getCentre().y - (getRayon() / 6 + 2 * getRayon()) - getRayon() / 3, 2 * getRayon() / 4, getRayon() / 3,
				p.getZone(3).getCase(11));
		drawEmplacement(g, getCentre().x - (getRayon() / 8) - 2 * (getRayon() / 4),
				getCentre().y + (getRayon() / 6 + 2 * getRayon()), 2 * getRayon() / 4, getRayon() / 3,
				p.getZone(3).getCase(6));

		drawEmplacement(g, getCentre().x + (int) (getRayon() / 8 + 1.5 * getRayon()),
				getCentre().y + (int) (getRayon() / 6 + 1.5 * getRayon()), 2 * getRayon() / 4, getRayon() / 3,
				p.getZone(3).getCase(4));
		drawEmplacement(g, getCentre().x + (int) (getRayon() / 8 + 1.5 * getRayon()),
				getCentre().y - (int) (getRayon() / 6 + 1.5 * getRayon()) - getRayon() / 3, 2 * getRayon() / 4,
				getRayon() / 3, p.getZone(3).getCase(1));
		drawEmplacement(g, getCentre().x - (int) (getRayon() / 8 + 1.5 * getRayon()) - 2 * (getRayon() / 4),
				getCentre().y - (int) (getRayon() / 6 + 1.5 * getRayon()) - getRayon() / 3, 2 * getRayon() / 4,
				getRayon() / 3, p.getZone(3).getCase(10));
		drawEmplacement(g, getCentre().x - (int) (getRayon() / 8 + 1.5 * getRayon()) - 2 * (getRayon() / 4),
				getCentre().y + (int) (getRayon() / 6 + 1.5 * getRayon()), 2 * getRayon() / 4, getRayon() / 3,
				p.getZone(3).getCase(7));

	}

	/**
	 * Dessine les emplacements
	 * 
	 * @param graph
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param c
	 */
	public void drawEmplacement(Graphics graph, int x, int y, int width, int height, Case c) {
		/**
		 * augmente la taille de l'emplacement en fonction de sa position
		 */
		/*
		 * if(zone==2){ width= (int) (width*1.2); height= (int) (height*1.2); //x=(int)
		 * (x-width*1.2); //y=(int) (y-height*1.2); }else if(zone==3){ width=(int)
		 * (width*1.4); height=(int) (height*1.4); }
		 */

		Graphics2D g = (Graphics2D) graph;

		Stack<Color> myColorStack = new Stack<Color>();

		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 4; i++) {

				if (j * 4 + i < c.getZerb().size()) {
					myColorStack.push(c.getZerb().get(j * 4 + i).getBelonging());
				}

				if (j * 4 + i < c.getCrapit().size()) {
					myColorStack.push(c.getCrapit().get(j * 4 + i).getBelonging().darker().darker());
				}

				if (j * 4 + i < c.getKrogul().size()) {
					myColorStack.push(c.getKrogul().get(j * 4 + i).getBelonging().darker().darker().darker().darker());
				}

			}
		}

		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 4; i++) {

				if (!myColorStack.isEmpty()) {
					g.setColor(myColorStack.pop());
				} else {
					g.setColor(Color.WHITE);
				}

				g.fillRect(x + i * width / 4, y + j * height / 3, width / 4, height / 3);

			}
		}

		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height - 1);
		g.drawRect(x, y + height / 3, width, height / 3);
		g.drawRect(x + width / 4, y, width / 2, height - 1);
		g.drawRect(x + width / 2, y, width / 4, height - 1);

	}

	/**
	 * 
	 * @return centre
	 */
	public Point getCentre() {
		return centre;
	}

	/**
	 * 
	 * @return rayon
	 */
	public int getRayon() {
		return rayon;
	}
}