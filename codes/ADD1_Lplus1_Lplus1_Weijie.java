package YaoGC;
public class ADD1_Lplus1_Lplus1_Weijie extends CompositeCircuit
{
	private final int L;
	public ADD1_Lplus1_Lplus1_Weijie(int L)
	{
		super(L+1, L+1, 1, "ADD1_Lplus1_Lplus1_L+1");
		this.L = L;
	}
	protected void createSubCircuits() throws Exception 
	{
		subCircuits[0] = new ADD_2L_Lplus1(L);
		super.createSubCircuits();
	}
	protected void connectWires() 
	{
		inputWires[0+0].connectTo(subCircuits[0].inputWires, 0+0);
		for( int j=0; j<L; j=j+1)
		{
			inputWires[0+1+j*1].connectTo(subCircuits[0].inputWires, 0+1+j*2);
		}
	}
	protected void defineOutputWires() 
	{
		for( int j=0; j<L+1; j=j+1)
		{
			outputWires[0+0+j*1] = subCircuits[0].outputWires[0+0+j*1];
		}
	}
	protected void fixInternalWires() 
	{
		for( int k=0; k<L-1; k=k+1)
		{
			subCircuits[0].inputWires[0+2+k*2].fixWire(0);
		}
	}
}
