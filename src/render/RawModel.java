package render;

public class RawModel {
    private int vaoID;
    private int vertexCount;

    RawModel(int vaoID, int vertexCount){
        this.vaoID = vaoID;
        this.vertexCount = vertexCount;
    }

    int getVaoID() {
        return vaoID;
    }

    int getVertexCount() {
        return vertexCount;
    }
}
