
import java.util.*;
import java.io.*;


public class DisjoinSetToDetectCycle {

	public HashMap<Integer, ArrayList<Integer>> toGraphFromFile(String filePath) {

		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

		try {

			File inputFile = new File(filePath);

			FileReader fr = new FileReader(inputFile);

			BufferedReader br = new BufferedReader(fr);

			String fileData = null;

			while((fileData = br.readLine()) != null) {

				String[] keyValue = fileData.split(":");

				String[] value = keyValue[1].split(",");

				ArrayList<Integer> keys = new ArrayList<>();

				for(String v : value) {

					keys.add(Integer.parseInt(v));
				}

				graph.put(Integer.parseInt(keyValue[0]), keys);

			} 

		} catch(Exception ex) {

				System.out.println(ex.getMessage());
		}

		return graph;
	}

	public boolean detectCycle(HashMap<Integer, ArrayList<Integer>> graph) {

		HashMap<Integer, Integer> initializeParent = initializeParent(graph);

		for(Map.Entry<Integer, ArrayList<Integer>> keyValElement : graph.entrySet()) {

			Integer key = keyValElement.getKey();

			Integer parentKey = find(key, initializeParent);

			ArrayList<Integer> values = keyValElement.getValue();

			for(Integer valElement : values) {

				Integer parentVal = find(valElement, initializeParent);

				if(parentKey == parentVal) return true;

				union(parentKey, parentVal, initializeParent);
			}
		}

		return false;
	}

	public Integer find(Integer key, HashMap<Integer, Integer> parentMap) {

		if(parentMap.get(key) == -1) return key;

		return find(parentMap.get(key), parentMap);
	}

	public void union(Integer parentKey, Integer parentVal, HashMap<Integer, Integer> initializeParent) {

		initializeParent.put(parentKey, parentVal);
	}



	public HashMap<Integer, Integer> initializeParent(HashMap<Integer, ArrayList<Integer>> graph) {

		HashMap<Integer, Integer> parentMap = new HashMap<>();

		for(Map.Entry<Integer, ArrayList<Integer>> keyValElement : graph.entrySet()) {

			if(!parentMap.containsKey(keyValElement.getKey())) {

				parentMap.put(keyValElement.getKey(), -1);
			}

			for(Integer valElement : keyValElement.getValue()) {

				if(!parentMap.containsKey(valElement)) {

				parentMap.put(valElement, -1);
			}

			}
		}

		return parentMap;
	}
 
	public static void main(String[] args) {

		DisjoinSetToDetectCycle testInstance = new DisjoinSetToDetectCycle();

		HashMap<Integer, ArrayList<Integer>> graph = testInstance.toGraphFromFile("C:/Users/Kartik/Documents/Summer2019/Git/DataStructures/DisjointSet/InputGraph.txt");

		System.out.println("Is cycle present -> " + testInstance.detectCycle(graph));
	}
}