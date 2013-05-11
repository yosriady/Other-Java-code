import java.util.Iterator;


public class Tower implements IBody{

	IBody[] blockList = new Block[1000];
	double weight;
	double length;
	double centerOfMass;
	int numBlocks = 0;
	

	public Tower(IBody first, IBody second, double distance){
		this.weight = first.getMass() + second.getMass();
		this.length = first.getLength() + (second.getLength()-first.getLength() + distance);
		this.centerOfMass = ((first.getCenterOfMass()*first.getMass()) + (distance+second.getCenterOfMass()*second.getMass()))/this.weight;
		
		if(first instanceof Tower){
			IBody[] bottom = ((Tower) first).blockList;
			
			for(int i = ((Tower) first).numBlocks; i<((Tower) first).numBlocks+numBlocks;i++){
				
				
				bottom[i] = blockList[i-((Tower) first).numBlocks];
				blockList = bottom;
				
				
			}
	
			numBlocks +=((Tower) first).numBlocks;

		}
		
		
		if(first instanceof Block){
			blockList[numBlocks] = first;
			numBlocks++;
		}
		
		
		if(second instanceof Block){
			blockList[numBlocks] = second;
			numBlocks++;
		}

	}

	@Override
	public double getLength() {
		return this.length;
	}

	@Override
	public double getCenterOfMass() {
		return this.centerOfMass;
	}

	@Override
	public double getMass() {
		return this.weight;
	}
	

	@Override
	public Iterator<Block> iterator() {
		return new TowerIterator(this);
	}

	
	class TowerIterator implements Iterator<Block>{
		
		Block[] blocks;
		int currentIndex;
		int numBlocks;
		
		public TowerIterator(Tower tower) {
			blocks = (Block[]) tower.blockList;
			currentIndex = 0;
			numBlocks = tower.numBlocks;
		}

		@Override
		public boolean hasNext() {
            return currentIndex < numBlocks && blocks[currentIndex] != null;
        }

		@Override
		public Block next() {
			return blocks[currentIndex++];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}

	}
	
	
	public static void main(String[] args) {
		
		Block a = new Block(1,1);
		Block b = new Block(1,1);
		Block c = new Block(1,1);
		Tower base = new Tower(a,b,0.25);
		Tower entire = new Tower(base,c,0.75);
		
		System.out.println(entire.getLength());
		System.out.println(entire.getMass());
		System.out.println(entire.getCenterOfMass());
		System.out.println(entire.numBlocks);
		
		
		System.out.println(entire.blockList[0]);
		
		for(Block B : entire){
			System.out.print(B.getLength());
		}
		
		
		
		
	}
	


}
