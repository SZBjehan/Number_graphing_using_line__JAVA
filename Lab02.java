import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import javax.swing.JFrame;



public class Lab02 implements GLEventListener{

    static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas
    static GLCanvas glcanvas = new GLCanvas(capabilities);

    public static void main(String[] args) {

        Lab02 l= new Lab02();
//creating frame
        glcanvas.addGLEventListener(l);
        glcanvas.setSize(600, 400);

        final JFrame frame = new JFrame ("straight Line");
//adding canvas to frame
        frame.getContentPane().add(glcanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);

    }
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glPointSize(5);
        gl.glBegin (GL2.GL_POINTS);//static field
       
        // draw 1
        DDA(gl,-0.3,0.0,-0.3,0.4);
        
        // draw 2
        DDA(gl,-0.2,0.4,0,0.4);
        DDA(gl,-0.2,0.2,0,0.2);
        DDA(gl,-0.2,0,0,0);
        
        DDA(gl,0,0.2,0,0.4);
        DDA(gl,-0.2,0,-0.2,0.2);
        
        // draw 3
        DDA(gl,0.1,0.4,0.3,0.4);
        DDA(gl,0.3,0,0.3,0.4);
        DDA(gl,0.1,0,0.3,0);
        DDA(gl,0.1,0.2,0.3,0.2);
        
        // draw 4
//        DDA(gl,0.10,0.10,0.10,0.40);
//        
//        DDA(gl,0.10,0.10,0.40,0.10);
//
//        DDA(gl,0.40,-0.30,0.40,0.40);
        
        // draw 5
//        DDA(gl,-0.2,-0.1,0,-0.1);
//        DDA(gl,-0.2,-0.3,0,-0.3);
//        DDA(gl,-0.2,-0.5,0,-0.5);
//        
//        DDA(gl,-0.2,-0.3,-0.2,-0.1);
//        DDA(gl,0,-0.5,0,-0.3);  
        
        // draw 6
//      DDA(gl,-0.30,0.40,0,0.40);          
//      DDA(gl,-0.30,0.10,0,0.10);
//      DDA(gl,-0.30,-0.30,0,-0.30);
//      
//      DDA(gl,-0.30,-0.30,-0.30,0.40);
//      DDA(gl,0,-0.30,0,0.10);
        
        // draw 7
//        DDA(gl,0.1,-0.1,0.3,-0.1);
//        DDA(gl,0.3,-0.5,0.3,-0.1);
        
        // draw 8
        DDA(gl,0.4,-0.1,0.6,-0.1);
        DDA(gl,0.4,-0.3,0.6,-0.3);
        DDA(gl,0.4,-0.5,0.6,-0.5);
        
        DDA(gl,0.4,-0.5,0.4,-0.1);
        DDA(gl,0.6,-0.5,0.6,-0.1);
        
        // draw 9
//        DDA(gl,0.4,0.4,0.6,0.4);
//        DDA(gl,0.4,0.2,0.6,0.2);
//        DDA(gl,0.4,0,0.6,0);
//        
//        DDA(gl,0.4,0.2,0.4,0.4);
//        DDA(gl,0.6,0,0.6,0.4);
        
        gl.glEnd();

    }

    public void DDA(GL2 gl, double x1, double y1, double x2, double y2) {

        if (x1!=x2) {
            double m = (y2 - y1) / (x2 - x1);
            double x = x1;
            double y = y1;
            gl.glVertex2d(x, y);
            while (x < x2) {
                if (m < 1 && m > -1) {
                    x = x + 0.00001;
                    y = y + (m * 0.00001);
                } else {
                    y = y + (0.00001);
                    x = x + ((1 / m) * 0.00001);
                }
                gl.glVertex2d(x, y);
            }
            m = 0.0;
        }else{
            double y = y1;
            while(y<=y2){
                gl.glVertex2d(x1, y);
                y = y + (0.00001);
            }
        }

    }

    public void dispose(GLAutoDrawable arg0) {
//method body
    }

    public void init(GLAutoDrawable drawable) {
// method body
//4. drive the display() in a loop
    }

    public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
// method body
    }
//end of main
}//end of classimport javax.media.opengl.GL2;