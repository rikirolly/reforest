package reforest.data;

import org.junit.Test;
import scala.Option;
import static junit.framework.Assert.assertTrue;

/**
 * Created by lulli on 6/7/17.
 */
public class RotationMatrixTest {
    private final double[][] r = {{0.196319368905337, -0.327175014642606, 0.0721021455180706, 0.158157037632222, -0.0724520060140864, 0.271070493682438, -0.756053694579398, 0.338797042016847, 0.239714153012937, 0.0401352912456466},
            {-0.0992605743657903, 0.135257447539004, 0.52028643058393, 0.16598455992817, 0.396820248416089, 0.403959178723581, -0.0630399464455697, -0.312444697444082, -0.0102835930519755, -0.501251547184258},
            {0.62868846480057, -0.338455789148495, 0.17847232446871, 0.0889774307135811, 0.0194429332664437, 0.0409990567685426, 0.219054726191148, 0.131881701743377, -0.616858664686623, -0.0497777099777731},
            {0.0663409361304582, -0.602981298326761, -0.357524283816709, 0.0358660733870002, 0.469712324431935, -0.271577676945366, 0.0682397740194003, -0.264406707734837, 0.283340658132921, -0.231665363357949},
            {0.404634875493313, -0.0733709703888127, 0.243249284036466, -0.11930963227128, -0.315181359075091, 0.215395287973792, 0.428599119439635, -0.0462784280526267, 0.652615699312848, -0.00132190580901304},
            {0.147161940940014, -0.0379393439723864, 0.0654293057039074, -0.485657455532867, -0.422858676126422, -0.239975829241754, -0.370931215704996, -0.510832945055273, -0.126910866237819, -0.292771788352356},
            {0.435439690996304, 0.540438316282213, -0.269157296507959, 0.22711825455052, 0.0623454226514652, -0.300681244727521, -0.0923667424663369, 0.22683901172804, 0.137765816623012, -0.470135315354695},
            {0.0838220201825802, 0.0483317872583951, -0.555456990306915, 0.377329750743785, -0.265925273509421, 0.52139402315031, 0.0131384179583318, -0.429366140137768, -0.110064015657792, 0.0227537263286347},
            {-0.12940326435269, -0.0610439956630785, -0.332304719003986, -0.575303574796832, 0.0400141246690422, 0.434712496222892, 0.123080682039756, 0.399382188578236, -0.0854329713087463, -0.406937258487226},
            {0.391395782392863, 0.302596377126326, -0.0978344203041635, -0.403979604594634, 0.511784739730271, 0.180784376335736, -0.163177439738482, -0.204650536918033, 0.0350558481722119, 0.467043292651774}};

    private final double[][] m = {{0.554326939220179, -1.09359397160108, 0.262542670981165, -0.00821067005591938, 0.100340345082963, 0.27312918928982, -1.2615741511362, -1.08680214934936, -0.0760621578891206, 0.379895700157524},
            {-0.280271939952888, 0.461870908226753, 1.83616330184588, 0.847797375737756, 1.59003352696834, 0.755525068917924, 0.298271743700421, -0.0614469851672869, 0.297513215720422, -0.56550536431604},
            {1.77516336956021, -1.36098453256021, 0.35740241881979, -0.383491495680503, 0.566494876111756, -0.349018411361478, -0.147807105946693, -0.516697344373546, -1.19435471065916, -1.21377809780239},
            {0.187320121673427, -1.85602715431898, -1.04541012650827, -0.526511510275127, 1.61447949380622, -0.546190759014352, -0.888922333659192, -1.90767368895648, -1.99687548467608, -1.36430159260496},
            {1.14252614647565, -0.439855409163339, 0.620184127337731, -0.273225962809109, -0.468650159224997, 0.234361994950301, 1.01306585838081, 0.107156481308445, 1.38851304735604, -1.41613295003786},
            {0.415526133492785, -0.193946900574085, 0.149354529304505, -0.605741605348354, -0.726101400548042, -0.297828222180418, -0.920525082596555, -1.17737518759516, -0.082483573565011, -0.255578030421819},
            {1.22950655592903, 1.39643151363809, -1.45931685394734, -0.33286730546774, -1.02333900186344, -0.840476132781401, -0.573894504193864, 1.74542691251586, 0.392514487605017, -1.22542595393505},
            {0.236679672240931, 0.100663245719, -2.02704380077946, -0.241537545517952, -1.93781552657884, 0.826510356055471, 1.15036548458217, -0.398698526583045, -1.08276971342343, 0.213834264499421},
            {-0.365382773252059, -0.114438810048087, -1.05695776024492, -0.862775399222633, 0.27714728924503, 1.48369123109091, 1.14382456210206, 0.44243942439518, 1.60212039143709, 0.067223555567545},
            {1.10514427225028, 0.702225229925947, -0.728143715858865, -0.846970752447282, 1.40835366660647, 0.699675641418199, -0.239442762768268, 0.450279462089082, 1.00406896944236, 0.856635112998544}};

    private final RotationMatrix matrix = new RotationMatrix(m.length, 0, Option.<double[][]>apply(m));

    @Test
    public void generateRotationMatrix() {
        double maxError = 0.00000001;
        double[][] generatedMatrix = matrix.getGeneratedMatrix();

        for(int i = 0; i < generatedMatrix.length; i++){
            for(int j = 0; j < generatedMatrix.length; j++) {
                assertTrue("error is "+Math.abs(generatedMatrix[i][j]-r[i][j]), Math.abs(generatedMatrix[i][j]-r[i][j])<maxError);
            }
        }
    }
}
