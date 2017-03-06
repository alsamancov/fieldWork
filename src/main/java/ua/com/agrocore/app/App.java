package ua.com.agrocore.app;


import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryCollection;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.Point;

import java.util.ArrayList;

public class App {
    private static ArrayList<Double> distances = new ArrayList<Double>();


    public double[] getDistances(GeometryCollection list) {
        for(int i = 0; i < list.getNumGeometries() - 1; i++){
            Point currentPoint = (Point) list.getGeometryN(i);
            Point nextPoint = (Point) list.getGeometryN(i + 1);
            currentPoint = CoordinateTransformer.conversion(currentPoint);
            nextPoint = CoordinateTransformer.conversion(nextPoint);

            distances.add(currentPoint.distance(nextPoint));
        }
        double[] result = new double[distances.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = distances.get(i).doubleValue();

        }
        return result;
    }

    public static ArrayList<Double> getDistances() {
        return distances;
    }

    public double[] getAllDistances(ArrayList<LineString> lines, LineString curve){
        ArrayList<Double> dist = getDistances();

        for(LineString line : lines){
            Geometry geometry = getGeometry(curve, line);
            for(int i = 0; i < geometry.getNumGeometries() - 1; i++){
                Point currentPoint = (Point) geometry.getGeometryN(i);
                Point nextPoint = (Point) geometry.getGeometryN(i + 1);
                currentPoint = CoordinateTransformer.conversion(currentPoint);
                nextPoint = CoordinateTransformer.conversion(nextPoint);
                distances.add(currentPoint.distance(nextPoint));
            }

        }
        double[] resultArray = new double[distances.size()];
        for(int i = 0; i < resultArray.length; i++){
            resultArray[i] = distances.get(i).doubleValue();

        }
        return resultArray;
    }





    public Geometry getGeometry(LineString curve, LineString currentLine){
        return curve.intersection(currentLine);
    }


}