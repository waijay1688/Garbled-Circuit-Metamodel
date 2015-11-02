package YaoGC;
public class MUX_3_1 extends CompositeCircuit
{
	public MUX_3_1()
	{
		super(3, 1, 3, "MUX_3_1_3");
	}
	protected void createSubCircuits() throws Exception 
	{
		subCircuits[2] = AND_2_1.newInstance();
		for( int i=0; i<2; i=i+1)
		{
			subCircuits[0+i*1] = XOR_2_1.newInstance();
		}
	}
	super.createSubCircuits();
	protected void connectWires() 
	{
		inputWires[0+2].connectTo(subCircuits[2].inputWires, 0+0);
		inputWires[0+1].connectTo(subCircuits[1].inputWires, 0+1);
		for( int i=0; i<2; i=i+1)
		{
			inputWires[0+i*0+0].connectTo(subCircuits[0+i*1].inputWires, 0);
		}
		subCircuits[2].outputWires[0+0].connectTo(subCircuits[0].inputWires, 0+1);
		subCircuits[1].outputWires[0+0].connectTo(subCircuits[2].inputWires, 0+1);
	}
	protected void defineOutputWires() 
	{
		outputWires[0+0] = subCircuits[0].outputWires[0+0];
	}
	protected void fixInternalWires() 
	{
	}
}
