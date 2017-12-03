package com.sg.mall;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.mall.model.Brand;
import com.sg.mall.model.Category;
import com.sg.mall.model.Product;

@Service
public class InputProcessor {

	private static final Log log = LogFactory.getLog(InputProcessor.class);

	@Autowired
	private Context context;

	public void processInputs(String fileName) throws Exception {

		log.info("Input file : " + fileName);

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
			Map<Integer, Product> productMap = getProductMap(context, br);
			br.readLine();
			int numUserChoices = Integer.parseInt(br.readLine());
			List<Double> results = new ArrayList<>();

			for (int i = 0; i < numUserChoices; i++) {
				Double userTotal = getUserTotal(br, productMap);
				results.add(userTotal);
			}

			for (Double result : results) {
				System.out.println(result);
			}
		}
	}

	private Double getUserTotal(BufferedReader br, Map<Integer, Product> productMap) throws IOException {
		String userChoiceLine = br.readLine();
		String[] userChoiceSplit = userChoiceLine.split(",");

		Double userTotal = 0d;
		for (int j = 0; j < userChoiceSplit.length; j++) {
			userTotal += productMap.get(Integer.parseInt(userChoiceSplit[j])).getDiscountedPrice();
		}
		return userTotal;
	}

	private Map<Integer, Product> getProductMap(Context context, BufferedReader br) throws IOException {
		int numProducts = Integer.parseInt(br.readLine());

		Map<Integer, Product> productMap = new HashMap<>();
		for (int i = 0; i < numProducts; i++) {
			String productLine = br.readLine();
			String[] splitLine = productLine.split(",");
			int productId = Integer.parseInt(splitLine[0]);
			Brand b = context.getBrand(splitLine[1].trim());
			Category c = context.getCategory(splitLine[2].trim());

			if (b == null)
				throw new RuntimeException("Could not find given brand");

			if (c == null)
				throw new RuntimeException("Could not find given category");

			productMap.put(productId, new Product(b, c, Double.parseDouble(splitLine[3])));
		}
		return productMap;
	}

}
