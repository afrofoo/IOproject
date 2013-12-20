package controller;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import ioModel.Game;
import view.IoFrame;

/**
 * Controller class for the IO Project
 * 
 * @author jfun3832 13/12/2012
 */
public class IoController
{
	private IoFrame appFrame;

	public IoController()
	{

	}

	public void start()
	{
		appFrame = new IoFrame(this);

	}
	public Game readGameInformation()
	{
		String fileName = "save file.txt"; //	Without a path it will look to the directory of the project 
		File currentSaveFile = newFile(fileName);
		Scanner fileReader;
		Game currentGame = null;
		int gameRanking = 0;
		String gameTtitle = "";
		ArrayList<String> gameRules = new ArrayList<String>();
		
		try
		{
			fileReader = new Scanner(currentSaveFile);
			gameTitle = fileReader.nextLine();
			gameRanking = fileReader.nextInt();
			while(fileReader.hasNext())
			{
				gameRules.add(fileReader.nextLine());
			}
			
			currentGame = new Game(gameRules, gameRanking,gameTitle);
			fileReader.close();
		}
		catch(FileNotFoundException currentFileDoesNotExist)
		{
			JOptionPane.showMessageDialog(appFrame, currentFileDoesNotExist.getMessage());
		}
		return currentGame;
	}
	public Game makeGameFromInput(String gameTitle, String gameRanking, String gameRules)
	{
		currentGame.setFunRanking(Interger.parseInt(gameRanking));
	}
	else
	{
		return null;
	}
	{
	String [] temp = gameRules.split("\n");
	ArrayList<String> tempRules = new ArrayList<String>();
	
	for (String tempWord : temp)
	{
		tempRules.add(tempWord);
	}
	currentGame.setGameRules(tem);
	
	return currentGame;
}

private boolean checkNumberFormat(String toBeParsed)
{
	boolean isNumber = false;
	
	try
	{
		int valid = Interger.parseInt(toBeParsed);
		isNumber = true;
	}
	catch (NumberFormatExcaption error)
	{
		JOptionPane.showMessageDialog(appFrame, "Please try again with an actual number.");
	}
	return isNumber;
}
	

	public void saveGameInformation(Game currentGame)
	{
		PrintWriter gameWriter;
		String saveFile = "save file.txt";

		try
		{
			gameWriter = new PrintWriter(saveFile);// creates the save file

			gameWriter.println(currentGame.getGameTitle());
			gameWriter.println(currentGame.getFunRanking());
			for (int count = 0; count < currentGame.getGameRules().size(); count++)
			{
				gameWriter.println(currentGame.getGameRules().get(count));

			}

			gameWriter.close(); // Require to prevent corruption of data and
								// maintain security of the file.
		}
		catch (FileNotFoundException notFileExists)
		{
			JOptionPane.showMessageDialog(appFrame, "Could not create the save file. :(");
			JOptionPane.showMessageDialog(appFrame, notFileExists.getMessage());
		}
	}
}
