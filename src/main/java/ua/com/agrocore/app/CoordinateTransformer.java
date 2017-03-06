package ua.com.agrocore.app;


import com.vividsolutions.jts.geom.Point;
import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.CRS;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;
import org.opengis.referencing.operation.TransformException;

public class CoordinateTransformer {
    private static final String SR_ORG_7356 = "PROJCS[\"UA-63_CM 29.5E\"," +
            "GEOGCS[\"UA-42\", " +
            "  DATUM[\"Pulkovo_1942\", " +
            "    SPHEROID[\"Krasovsky_1940\", 6378245.0, 298.3, AUTHORITY[\"EPSG\",\"7356\"]], " +
            "    TOWGS84[21.0, -124.0, -82.0, 0.0, 0.0, 0.0, 0.0], " +
            "    AUTHORITY[\"EPSG\",\"6269\"]], " +
            "  PRIMEM[\"Greenwich\", 0.0, AUTHORITY[\"EPSG\",\"8901\"]], " +
            "  UNIT[\"degree\", 0.017453292519943295], " +
            "  AXIS[\"Lon\", EAST], " +
            "  AXIS[\"Lat\", NORTH], " +
            "  AUTHORITY[\"EPSG\",\"4269\"]], " +
            "PROJECTION[\"Transverse_Mercator\"], " +
            "PARAMETER[\"central_meridian\", 29.5], " +
            "PARAMETER[\"latitude_of_origin\", 0], " +
            "PARAMETER[\"false_easting\", 3300000], " +
            "PARAMETER[\"false_northing\", -9214.692], " +
            "UNIT[\"m\", 1.0], " +
            "AXIS[\"x\", EAST], " +
            "AXIS[\"y\", NORTH], " +
            "AUTHORITY[\"EPSG\",\"3005\"]]";

    public static Point conversion(Point point){
        MathTransform transform;
        CoordinateReferenceSystem targetCRS = null;
        Point covertedPoint = null;
        try{
            targetCRS = CRS.parseWKT(SR_ORG_7356);
            transform = CRS.findMathTransform(DefaultGeographicCRS.WGS84, targetCRS, false);
            covertedPoint = (Point) JTS.transform(point, transform);
        } catch (FactoryException e) {
            e.printStackTrace();
        } catch (TransformException e) {
            e.printStackTrace();
        }
        return covertedPoint;
    }

}
