package YaoGC;
public class ADD_2L_L extends CompositeCircuit
{
	private final int L;
	public ADD_2L_L(int L)
	{
		super(2L, L, L, "ADD_2L_L_2L");
		this.L = L;
	}
	protected void createSubCircuits() throws Exception 
	{
		for( int i=0; i<L; i=i+1)
		{
			subCircuits[0+i*1] = new ADD_3_2(0);
		}
	}
	super.createSubCircuits();
	protected void connectWires() 
	{
		for( int i=0; i<L; i=i+1)
		{
			inputWires[0+i*1+0].connectTo(subCircuits[0+i*1].inputWires, 1);
		}
		for( int i=0; i<L; i=i+1)
		{
			inputWires[0+i*1+0].connectTo(subCircuits[0+i*1].inputWires, 0);
		}
		for( int i=0; i<L-1; i=i+1)
		{
			subCircuits[0+i*1].outputWires[1].connectTo(subCircuits[1+i*1].inputWires, 2);
		}
	}
	protected void defineOutputWires() 
	{
		outputWires[0] = subCircuits[0+i*1].outputWires[0];
	}
	protected void fixInternalWires() 
	{
		subCircuits[0].inputWires[0+2].fixWire(0);
	}
}
