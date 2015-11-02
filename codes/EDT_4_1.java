package YaoGC;
public class EDT_4_1 extends CompositeCircuit
{
	public EDT_4_1()
	{
		super(4, 1, 3, "EDT_4_1_4");
	}
	protected void createSubCircuits() throws Exception 
	{
		subCircuits[2] = OR_2_1.newInstance();
		for( int i=0; i<2; i=i+1)
		{
			subCircuits[0+i*1] = XOR_2_1.newInstance();
		}
	}
	super.createSubCircuits();
	protected void connectWires() 
	{
		for( int i=0; i<2; i=i+1)
		{
			for( int j=0; j<2; j=j+1)
			{
				inputWires[0+i*1+0+j*2].connectTo(subCircuits[0+i*1].inputWires, 0+j*1);
			}
		}
		for( int i=0; i<2; i=i+1)
		{
			subCircuits[0+i*1].outputWires[0].connectTo(subCircuits[2].inputWires, 0+i*1+0);
		}
	}
	protected void defineOutputWires() 
	{
		outputWires[0+0] = subCircuits[2].outputWires[0+0];
	}
	protected void fixInternalWires() 
	{
	}
}
