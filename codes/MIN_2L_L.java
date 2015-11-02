package YaoGC;
public class MIN_2L_L extends CompositeCircuit
{
	private final int L;
	public MIN_2L_L(int L)
	{
		super(2*L, L, 2, "MIN_2L_L_2*L");
		this.L = L;
	}
	protected void createSubCircuits() throws Exception 
	{
		subCircuits[0] = new GT_2L_1(L);
		subCircuits[1] = new MUX_2Lplus1_L(L);
	}
	super.createSubCircuits();
	protected void connectWires() 
	{
		for( int j=0; j<L; j=j+1)
		{
			inputWires[0+L+j*1].connectTo(subCircuits[1].inputWires, 0+1+j*2);
		}
		for( int j=0; j<L; j=j+1)
		{
			inputWires[0+0+j*1].connectTo(subCircuits[1].inputWires, 0+0+j*2);
		}
		for( int j=0; j<L; j=j+1)
		{
			inputWires[0+0+j*1].connectTo(subCircuits[0].inputWires, 0+0+j*2);
		}
		for( int j=0; j<L; j=j+1)
		{
			inputWires[0+L+j*1].connectTo(subCircuits[0].inputWires, 0+1+j*2);
		}
		subCircuits[0].outputWires[0+0].connectTo(subCircuits[1].inputWires, 0+2*L);
	}
	protected void defineOutputWires() 
	{
		for( int j=0; j<L; j=j+1)
		{
			outputWires[0+0+j*1] = subCircuits[1].outputWires[0+0+j*1];
		}
	}
	protected void fixInternalWires() 
	{
	}
}
