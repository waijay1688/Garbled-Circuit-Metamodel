package YaoGC;
public class GT_3_1_Weijie extends CompositeCircuit
{
	public GT_3_1_Weijie()
	{
		super(3, 1, 4, "GT_3_1_3");
	}
	protected void createSubCircuits() throws Exception 
	{
		subCircuits[3] = AND_2_1.newInstance();
		for( int i=0; i<3; i=i+1)
		{
			subCircuits[0+i*1] = new XOR_2_1();
		}
		super.createSubCircuits();
	}
	protected void connectWires() 
	{
		for( int i=0; i<2; i=i+1)
		{
			inputWires[0+i*0+0].connectTo(subCircuits[1+i*1].inputWires, 1);
		}
		for( int i=0; i<2; i=i+1)
		{
			inputWires[0+i*0+0].connectTo(subCircuits[0+i*1].inputWires, 0);
		}
		inputWires[0+0].connectTo(subCircuits[0].inputWires, 0+0);
		inputWires[0+1].connectTo(subCircuits[2].inputWires, 0+0);
		subCircuits[3].outputWires[0+0].connectTo(subCircuits[0].inputWires, 0+1);
		for( int i=0; i<2; i=i+1)
		{
			subCircuits[1+i*1].outputWires[0].connectTo(subCircuits[3].inputWires, 0+i*1+0);
		}
	}
	protected void defineOutputWires() 
	{
		outputWires[0+0] = subCircuits[0].outputWires[0+0];
	}
	protected void fixInternalWires() 
	{
	}
}
