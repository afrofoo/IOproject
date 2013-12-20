package view;

import javax.swing.*;

import java.awt.Color;
import controller.IoController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import io.controller.IOController;
import io.model.Game;

import javax.swing.*;

public class IoPanel extends JPanel
{

	private IoController baseController;
	private JButton saveButton;
	private JButton loadButton;
	private JTextField titleField;
	private JTextField rankingField;
	private JTextArea rulesArea;
	private JLabel rulesLabel;
	private JLabel rankingLabel;
	private JLabel titleLabel;
	private SpringLayout baseLayout;

	public IoPanel(IoController baseController)
	{
		this.baseController = baseController;

		saveButton = new JButton("save the game stuff");
		loadButton = new JButton("load the game stuff");
		titleField = new JTextField(15);
		titleLabel = new JLabel("Game Title:");
		rankingField = new JTextField(5);
		rankingLabel = new JLabel("Game Ranking:");
		rulesArea = new JTextArea(5, 20);
		rulesLabel = new JLabel("Game Rules:");
		baseLayout = new SpringLayout();

		setupPanel();
		setupLayout();
		setupListeners();

	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(rankingLabel);
		this.add(rankingField);
		this.add(titleField);
		this.add(titleLabel);
		;
		this.add(rulesArea);
		this.add(rulesLabel);
		this.add(saveButton);
	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.SOUTH, titleField, -14, SpringLayout.NORTH, rankingField);
		baseLayout.putConstraint(SpringLayout.NORTH, saveButton, 26, SpringLayout.SOUTH, rulesArea);
		baseLayout.putConstraint(SpringLayout.WEST, saveButton, 104, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, rulesLabel, 6, SpringLayout.SOUTH, rankingLabel);
		baseLayout.putConstraint(SpringLayout.EAST, rulesLabel, 0, SpringLayout.EAST, titleLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, titleLabel, 3, SpringLayout.NORTH, titleField);
		baseLayout.putConstraint(SpringLayout.WEST, titleLabel, 0, SpringLayout.WEST, rankingLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, rankingField, -3, SpringLayout.NORTH, rankingLabel);
		baseLayout.putConstraint(SpringLayout.WEST, rankingField, 16, SpringLayout.EAST, rankingLabel);
		baseLayout.putConstraint(SpringLayout.WEST, titleField, 127, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, rankingLabel, 0, SpringLayout.WEST, rulesArea);
		baseLayout.putConstraint(SpringLayout.SOUTH, rankingLabel, -27, SpringLayout.NORTH, rulesArea);
		baseLayout.putConstraint(SpringLayout.WEST, rulesArea, 28, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, rulesArea, -78, SpringLayout.SOUTH, this);

	}

	private void setupListeners()
	{
       saveButton.addActionListener(new ActionListener()
       	   {
    			   public void actionListener( ActionEvent click)
    			   {
    				   Game tempGame = baseController.makeGameFromInput(titleField.getText(), rankingField.getText(),rulesArea.getText());
    				   if (tempGame ! = null)
    				   {
    					   baseController.saveGameInformation(tempGame);
    				   }
    				   else
    				   {
    					   JOptionPane.showMessageDialog(null, "Try again with a valid number");
    				   }
    			   }
    		});
	}
}
