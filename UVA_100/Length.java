public class Length
{
  private int first;
  private int second;
  public Length(int first_input,int second_input)
  {
    first = first_input;
    second = second_input;
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
    System.out.println(first + " " + second + " " + realresult);
  } 
}
