package ca.sheridancollege.controllers;

import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ca.sheridancollege.beans.SquareMatrix;
import ca.sheridancollege.beans.StringForm;

@Controller
public class HomeController {

	@GetMapping("/")
	public String goMatrixForm(Model model)
	{
		model.addAttribute("squareMatrix", new SquareMatrix());
		return "form.html";
	}
	
	@GetMapping("/matrixFormResults")
	public String populateMatrix(Model model, @ModelAttribute SquareMatrix squareMatrix)
	{
		char[][] matrix = new char[squareMatrix.getLength()][squareMatrix.getLength()];
		Random rand = new Random();
		for (int i=0;i<matrix.length;i++)
		{
			for (int j=0;j<matrix.length;j++)
			{
				matrix[i][j]=(char)(rand.nextInt(26)+97);
			}
		}
		
		model.addAttribute("matrix",matrix);
		model.addAttribute("stringForm", new StringForm());
		
		return "display.html";
	}
	
	@GetMapping("/stringFormResults")
	public String searchString(Model model, @ModelAttribute SquareMatrix squareMatrix, @ModelAttribute StringForm stringForm)
	{
		String string = stringForm.getString();
		
		return "display.html";
	}
}
