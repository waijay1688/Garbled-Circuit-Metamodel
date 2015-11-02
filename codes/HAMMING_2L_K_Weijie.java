package YaoGC;
public class HAMMING_2L_K_Weijie extends CompositeCircuit
{
	private final int L;
	private final int  K;
	public HAMMING_2L_K_Weijie(int L, int  K)
	{
		super(2*K, K, L+1, "HAMMING_2L_K_2*K");
		this.L = L;
		this. K =  K;
	}
	protected void createSubCircuits() throws Exception 
	{
		for( int i=0; i<L; i=i+1)
		{
			subCircuits[0+i*1] = new XOR_2_1();
		}
		subCircuits[L] = new COUNTER_L_K(L,  K);
		super.createSubCircuits();
	}
	protected void connectWires() 
	{
		for( int i=0; i<L; i=i+1)
		{
			inputWires[0+i*1+0].connectTo(subCircuits[0+i*1].inputWires, 1);
		}
		for( int i=0; i<L; i=i+1)
		{
			inputWires[L+i*1+0].connectTo(subCircuits[0+i*1].inputWires, 0);
		}
		for( int i=0; i<L; i=i+1)
		{
			subCircuits[0+i*1].outputWires[0].connectTo(subCircuits[L].inputWires, 0+i*1+0);
		}
	}
	protected void defineOutputWires() 
	{
		for( int i=0; i<K; i=i+1)
		{
			outputWires[0+i*1+0] = subCircuits[L].outputWires[0+i*1+0];
		}
	}
	protected void fixInternalWires() 
	{
	}
}
