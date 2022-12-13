/*
 * 
 */
package MonthCalendar;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.Timer;

// TODO: Auto-generated Javadoc
/**
 * The Class PanelSlide.
 */
public class PanelSlide extends javax.swing.JPanel {

    /**
     * Gets the animate.
     *
     * @return the animate
     */
    public int getAnimate() {
        return animate;
    }

    /**
     * Sets the animate.
     *
     * @param animate the new animate
     */
    public void setAnimate(int animate) {
        this.animate = animate;
    }

    /**
     * Instantiates a new panel slide.
     */
    public PanelSlide() {
		initComponents();
        setLayout(null);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent ce) {
                comShow.setSize(getSize());
            }

        });
        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                animate();
            }
        });

    }

    /** The timer. */
    private final Timer timer;
    
    /** The com exit. */
    private Component comExit;
    
    /** The com show. */
    private Component comShow;
    
    /** The animate type. */
    private AnimateType animateType;
    
    /** The animate. */
    private int animate = 1;

    /**
     * Show.
     *
     * @param com the com
     * @param animateType the animate type
     */
    public void show(Component com, AnimateType animateType) {
        if (!timer.isRunning()) {
            this.animateType = animateType;
            this.comShow = com;
            com.setSize(getSize());
            if (getComponentCount() == 0) {
                add(com);
                comExit = com;
                repaint();
                revalidate();
            } else {

                if (animateType == AnimateType.TO_RIGHT) {
                    comShow.setLocation(-comShow.getWidth(), 0);
                } else {
                    comShow.setLocation(getWidth(), 0);
                }
                add(com);
                repaint();
                revalidate();
                timer.start();

            }
        }
    }

    /**
     * Animate.
     */
    private void animate() {
        if (animateType == AnimateType.TO_RIGHT) {
            if (comShow.getLocation().x < 0) {
                comShow.setLocation(comShow.getLocation().x + 1000, 0);
                comExit.setLocation(comExit.getLocation().x + 1000, 0);
            } else {
                //  Stop animate
                comShow.setLocation(0, 0);
                timer.stop();
                remove(comExit);
                comExit = comShow;
            }
        } else {
            if (comShow.getLocation().x > 0) {
                comShow.setLocation(comShow.getLocation().x - 1000, 0);
                comExit.setLocation(comExit.getLocation().x - 1000, 0);
            } else {
                comShow.setLocation(0, 0);
                timer.stop();
                remove(comExit);
                comExit = comShow;
            }
        }
    }

    /**
     * Inits the components.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 319, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 192, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * The Enum AnimateType.
     */
    public static enum AnimateType {
        
        /** The to right. */
        TO_RIGHT, 
 /** The to left. */
 TO_LEFT
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}