package YaoGC;
public class SUB_2L_L_Weijie extends CompositeCircuit
{
	private final int L;
	public SUB_2L_L_Weijie(int L)
	{
		super(2*L, L, L+1, "SUB_2L_L_2*L");
		this.L = L;
	}
	protected void createSubCircuits() throws Exception 
	{
		for( int i=0; i<L; i=i+1)
		{
			subCircuits[1+i*1] = new ADD_3_2();
		}
		subCircuits[0] = new XOR_2L_L(L);
		super.createSubCircuits();
	}
	protected void connectWires() 
	{
		for( int i=0; i<L; i=i+1)
		{
			inputWires[0+i*1+0].connectTo(subCircuits[0].inputWires, 0+i*1+0);
		}
		for( int i=0; i<L; i=i+1)
		{
			inputWires[L+i*1+0].connectTo(subCircuits[1+i*1].inputWires, 0);
		}
		for( int i=0; i<L-1; i=i+1)
		{
			subCircuits[1+i*1].outputWires[1].connectTo(subCircuits[2+i*1].inputWires, 2);
		}
		for( int i=0; i<L; i=i+1)
		{
			subCircuits[0].outputWires[0+i*1+0].connectTo(subCircuits[1+i*1].inputWires, 1);
		}
	}
	protected void defineOutputWires() 
	{
		for( int i=0; i<L; i=i+1)
		{
			outputWires[0+i*1+0] = subCircuits[1+i*1].outputWires[0];
		}
	}
	protected void fixInternalWires() 
	{
		for( int j=0; j<L; j=j+1)
		{
			subCircuits[0].inputWires[L+j*1+0].fixWire(1);
		}
		subCircuits[1].inputWires[0+2].fixWire(1);
	}
}
