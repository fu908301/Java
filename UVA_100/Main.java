import java.util.Scanner;

public class Main
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    int first_input;
    int second_input;
    while(input.hasNext())
    {
      first_input = input.nextInt();
      second_input = input.nextInt();
      Length RealLength = new Length(first_input,second_input);
      if(first_input > second_input)
       RealLength.swap();
      RealLength.result();
    }
  }
}

