package principal;

import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

import java.awt.event.KeyListener;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class JogoCGv2 implements GLEventListener {

        private Renderizador renderizador;

    public JogoCGv2() {

        JFrame telaPrincipal = new JFrame("ThayShooter");
        telaPrincipal.setBounds(50, 100, 800, 800);
        telaPrincipal.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        BorderLayout layout = new BorderLayout();
        Container caixa = telaPrincipal.getContentPane();
        caixa.setLayout(layout);

        GLProfile glp = GLProfile.getDefault();
        GLCapabilities caps = new GLCapabilities(glp);
        caps.setRedBits(8);
        caps.setBlueBits(8);
        caps.setGreenBits(8);
        caps.setAlphaBits(8);

        renderizador =  new Renderizador();

        GLCanvas canvas = new GLCanvas(caps);
        telaPrincipal.add(canvas, BorderLayout.CENTER);
        canvas.addGLEventListener((GLEventListener) renderizador);
        canvas.addMouseListener((MouseListener) renderizador);
        canvas.addKeyListener((KeyListener) renderizador);
        telaPrincipal.setVisible(true);
        FPSAnimator animator = new FPSAnimator(canvas, 50);
        animator.start();
        canvas.requestFocus();
    }

    public static void main(String[] args) {
        JogoCGv2 app = new JogoCGv2();
    }

    @Override
    public void init(GLAutoDrawable glad) {
    }

    @Override
    public void dispose(GLAutoDrawable glad) {
    }

    @Override
    public void display(GLAutoDrawable glad) {
    }

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
    }

}
