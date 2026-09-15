package edu.umn.d.cs1632;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MArray {

    private ArrayList<ArrayList<Value>> data;

    public MArray(String fileName) {
        data = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(fileName);
            CSVReader csvReader = new CSVReader(fileReader);

            List<String[]> allData = csvReader.readAll();

            for (String[] row : allData) {
                ArrayList<Value> newRow = new ArrayList<>();

                for (String cell : row) {
                    newRow.add(createValue(cell));
                }

                data.add(newRow);
            }

            csvReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Value createValue(String value) {

        try {
            int intValue = Integer.valueOf(value);
            return new IntValue(intValue);

        } catch (NumberFormatException e) {

            try {
                double doubleValue = Double.valueOf(value);
                return new DoubleValue(doubleValue);

            } catch (NumberFormatException e2) {
                return new StringValue(value);
            }
        }
    }

    public void printData() {

        for (ArrayList<Value> row : data) {

            for (Value value : row) {
                System.out.print(value + " ");
            }

            System.out.println();
        }
    }

    public String getType(int row, int col) {
        return data.get(row).get(col).getType();
    }

    public int getRows() {
        return data.size();
    }

    public int getColumns() {
        if (data.isEmpty()) {
            return 0;
        }

        return data.get(0).size();
    }

    public String verticalQuery(int col, int rowStart, int rowEnd) {

        String type = data.get(rowStart).get(col).getType();

        for (int row = rowStart; row <= rowEnd; row++) {

            if (!data.get(row).get(col).getType().equals(type)) {
                return "Multi";
            }
        }

        return type;
    }

    public String horizontalQuery(int row, int colStart, int colEnd) {

        String type = data.get(row).get(colStart).getType();

        for (int col = colStart; col <= colEnd; col++) {

            if (!data.get(row).get(col).getType().equals(type)) {
                return "Multi";
            }
        }

        return type;
    }

    public String matrixQuery(
            int rowStart,
            int rowEnd,
            int colStart,
            int colEnd) {

        String type = data.get(rowStart).get(colStart).getType();

        for (int row = rowStart; row <= rowEnd; row++) {

            for (int col = colStart; col <= colEnd; col++) {

                if (!data.get(row).get(col).getType().equals(type)) {
                    return "Multi";
                }
            }
        }

        return type;
    }
}