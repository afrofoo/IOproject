package view;

import javax.swing.JFrame;

import controller.IoController;

/**
 * fRAME FOR THE io PROCJET
 * 
 * @author jfun3832
 * 
 */
public class IoFrame extends JFrame
{
	private IoPanel basePanel;

	public IoFrame(IoController baseController)
	{
		basePanel = new IoPanel(baseController);
		setupFrame();
	}

	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(400, 400);
		this.setVisible(true);
	}
}
