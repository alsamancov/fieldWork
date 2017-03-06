package ua.com.agrocore.app;

import com.vividsolutions.jts.geom.GeometryCollection;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import junit.framework.TestCase;
import org.geotools.geometry.jts.FactoryFinder;

import java.util.ArrayList;


public class AppTest extends TestCase {

    public static void main(String[] args) throws ParseException {
        GeometryFactory geometryFactory = FactoryFinder.getGeometryFactory(null);
        WKTReader reader = new WKTReader(geometryFactory);
        LineString curve = (LineString) reader.read("LineString (31.02892235247964692 50.32851422261091301, 31.02844993678452923 50.34724630395500355, 31.03090389807897509 50.34841659612511222, 31.03304812214587116 50.34830244560280477, 31.03663235123965691 50.34705255394113976, 31.03709977737691617 50.34489891454540356, 31.03688360084692377 50.33820168964341235, 31.0368388278942291 50.32849573879219207, 31.0409802010189857 50.32792552568799493, 31.04475528508879734 50.32847671592375605, 31.04540600766444314 50.33198991481640405, 31.04449994071892505 50.33715587446819484, 31.04400959601111509 50.34686892274500991, 31.04524510027706086 50.34771149394181577, 31.04914201968680842 50.34783143487481993, 31.05258599927917729 50.34641112073425973, 31.05227265691338445 50.34091779533379452, 31.05264393663205169 50.33172167840847777, 31.05319144474586679 50.32793481875334862, 31.05827425022393484 50.32743730544341787, 31.06138447381609424 50.32816866386007604, 31.06174561946662394 50.33099847473774702, 31.06134135343927127 50.33504114819902497, 31.06114155590625003 50.34122853938161768, 31.06105338324446663 50.34672723642569991, 31.06244308982129354 50.3481688458097878, 31.06486404859639805 50.34830808468795738, 31.06819885716640783 50.34766186336086946, 31.06882449773381438 50.34627904466187687, 31.06936802857865842 50.34240626788833595, 31.06931543359535297 50.33673765927265009, 31.06977394314790786 50.33028905533129205, 31.06982036232558997 50.32762556215233474, 31.07355035840292246 50.32680204372456956, 31.07705177185521705 50.32718409210554, 31.07801009734917841 50.33180963216324955, 31.0774299147968307 50.33860351795824783, 31.07735215515961258 50.34435979261537852, 31.07747448300222004 50.34805177863945147)");
        LineString firstLine = (LineString) reader.read("LineString (31.01930386163881792 50.34667898583666101, 31.08610683628102578 50.3452714834460906)");
        LineString secondLine = (LineString) reader.read("LineString (31.02036960658484332 50.34219821283176799, 31.08677882051650698 50.34131124146514225)");
        LineString thirdLine = (LineString) reader.read("LineString (31.02090368484665817 50.33789667764433062, 31.08608387841571385 50.3365954538695064)");
        LineString forthLine = (LineString) reader.read("LineString (31.02438162460140347 50.33338416956726746, 31.08673184329063943 50.33177681865809916)");
        Point myPoint =(Point)reader.read("Point (31.06301568064288787 50.30593030733124493)");
        App app = new App();
        GeometryCollection list = (GeometryCollection) app.getGeometry(curve, firstLine);
        double[] distances = app.getDistances(list);

        for(int i = 0; i < distances.length; i++){
            System.out.println(distances[i]);
        }

        System.out.println("********************");
        ArrayList<LineString> lines = new ArrayList<LineString>();
        lines.add(firstLine);
        lines.add(secondLine);
        lines.add(thirdLine);
        lines.add(forthLine);

        double[] allDistances = app.getAllDistances(lines, curve);

        for(int i = 0; i < allDistances.length; i++){
            System.out.print(i + " ");
            System.out.println(allDistances[i]);
        }

                //new double[list.getNumGeometries() - 1];


//        for(int index = 0; index < list.getNumGeometries() - 1; index++){
//            final Geometry geometry = list.getGeometryN(index);
//            Point point = (Point) list.getGeometryN(index);
//            Point pointN = (Point) list.getGeometryN(index + 1);
//            System.out.println(point.distance(pointN));
//        }




    }




}
