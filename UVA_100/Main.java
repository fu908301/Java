import java.util.Scanner;
class Length
{
  private int first;
  private int second;
  private int output_first;
  private int output_second;
  public Length(int first_input,int second_input)
  {
    first = first_input;
    second = second_input;
    output_first = first_input;
    output_second = second_input;
  }
  public void swap()
  {
    int temp;
    temp = first;
    first = second;
    second = temp;
  }
  public int answer(int data)
  {
    int temp = 1;
    while(data != 1)
    {
      if(data % 2 != 0)
        data = data*3 + 1;
      else 
        data = data/2;
      temp++;
    }
    return temp;
  }
  public void result()
  { 
    int realresult = 0;
    int templength;
    for(int i = first;i <= second;i++)
    {
      templength = answer(i);
      if(templength > realresult)
        realresult = templength;
    }
    System.out.println(output_first + " " + output_second + " " + realresult);
  } 
}

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

