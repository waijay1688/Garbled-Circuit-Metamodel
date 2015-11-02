package YaoGC;
public class ADD_3_2 extends CompositeCircuit
{
	public ADD_3_2()
	{
		super(3, 2, 5, "ADD_3_2_3");
	}
	protected void createSubCircuits() throws Exception 
	{
		for( int i=0; i<4; i=i+1)
		{
			subCircuits[0+i*1] = XOR_2_1.newInstance();
		}
		subCircuits[4] = AND_2_1.newInstance();
	}
	super.createSubCircuits();
	protected void connectWires() 
	{
		for( int i=0; i<2; i=i+1)
		{
			inputWires[0+i*1+0].connectTo(subCircuits[3+i*-1].inputWires, 0);
		}
		for( int j=0; j<2; j=j+1)
		{
			inputWires[0+j*2].connectTo(subCircuits[1].inputWires, 0+0+j*1);
		}
		inputWires[2+0].connectTo(subCircuits[2].inputWires, 0+1);
		inputWires[2+0].connectTo(subCircuits[0].inputWires, 0+0);
		for( int i=0; i<2; i=i+1)
		{
			subCircuits[1+i*1].outputWires[0].connectTo(subCircuits[4].inputWires, 0+i*1+0);
		}
		subCircuits[2].outputWires[0+0].connectTo(subCircuits[3].inputWires, 0+1);
		subCircuits[4].outputWires[0+0].connectTo(subCircuits[0].inputWires, 0+1);
	}
	protected void defineOutputWires() 
	{
		for( int j=0; j<2; j=j+1)
		{
			outputWires[0+0+j*1] = subCircuits[0].outputWires[3+j*-3];
		}
	}
	protected void fixInternalWires() 
	{
	}
}
