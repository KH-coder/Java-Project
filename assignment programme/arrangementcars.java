import java.util.*;

public class arrangementcars {

	// The Number of tracks
	public static final int holding = 3;
	public static LinkedStack[] holdingTrack = new LinkedStack[holding];
	public static Comparator com = new NumberComparator();
	
	
	public static void main(String[] args) {
		
		LinkedStack intrack = new LinkedStack(com);
		LinkedStack outtrack = new LinkedStack(com);
		
		Scanner kb = new Scanner(System.in);
		
		LinkedStack track = new LinkedStack(com);

		// Enter the cargo
		while (!false) {
			System.out.print("Enter cargo number (enter <= 0 to exit) : ");
		
			int input = 0;

			//Check if input is not number
			try {
				input = kb.nextInt();
			}
			catch (InputMismatchException e) {
				System.out.println("just number.");
				kb.next();
				continue;
			}
			
			try {
				if (track.GetLinkedListInstance().FindObjectAvailability(input))
					throw new DuplicatonException();
				else if (input <= 0)
					break;
				else
					track.push(input);
			}

			catch (DuplicatonException e) {
				System.out.println(e.toString());
			}
		}
		
		int intrack_count = track.size();
		for (int i=0; i < intrack_count; i++) {
			intrack.push(track.pop());
		}
		
		System.out.println("\n\nNumber of Tracks = " + holding);
		System.out.println("Number of Cargos = " + intrack.size());
		System.out.println("Input order of cars (from left to right) is " + intrack.toString());
		

		for (int i = 0; i < holding; i++){
		
			holdingTrack[i] = new LinkedStack(com);
		}

		for (int i = 0; i < intrack_count; i++) {
			int item = (int)intrack.pop();
			int next = 0;
			for (int j = 0; j < holding; j++) {
				for (int k = 0; k < holdingTrack[j].size(); k++) {
					if ((int)holdingTrack[j].GetLinkedListInstance().getItemAt(k) < item)
						next++;
				}
			}
			for (int j = 0; j < intrack.size(); j++) {
				if ((int)intrack.GetLinkedListInstance().getItemAt(j) < item)
					next++;
			}
			
			if (next == 0) {
				System.out.println("Move car " + item + " from input track to output track.");
				outtrack.push(item);
				
				for (int j = 0; j < holding; j++) {
					int doublechk = 0;
					if (holdingTrack[j].isEmpty())
						continue;
					
					int top1 = ((Integer) (holdingTrack[j].top())).intValue();
					for (int p = 0; p < holding; p++) {
						
						if (holdingTrack[p].isEmpty())
							continue;
						
						int top2 = ((Integer) (holdingTrack[p].top())).intValue();
						
						if (top2 < top1)
							doublechk++;
					}
					for (int p = 0; p < intrack.size(); p++) {
						if ((int)intrack.GetLinkedListInstance().getItemAt(p) < top1)
							doublechk++;
					}
					
					if (doublechk == 0) {
						outtrack.push(holdingTrack[j].pop());
						System.out.println("Move car " + top1 + " from holding track " + (j + 1) + " to output track.");
						

						j = -1;
					}
				}
				
				continue;
			}
			Boolean moved= false;
			for (int y = 0; y < holding; y++) {
				int besthold = y + 1;
				int count = 0;
				
				for (int x = 0; x < holdingTrack[y].size(); x++) {
					if ((Integer)holdingTrack[y].GetLinkedListInstance().getItemAt(x) < item)
						count++;
				}
				
				if (count == 0) {
					System.out.println("Move car " + item + " from input track to holding track " + besthold);
					holdingTrack[y].push(item);
					moved = true;
					break;
				}
				
			}
			if (!moved) {
					System.out.println("Fail to rearrange the cars!");
					break;
			}
			
			
			

	}
	

	}
}
