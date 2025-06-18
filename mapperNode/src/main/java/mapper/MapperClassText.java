package mapper;

public class MapperClassText {

    String mapperClassText;

    public MapperClassText(String mapperClass) {
        mapperClassText= mapperClass;
    }

    public String getMapperClassText() {

        return mapperClassText;
    }

    public void setMapperClassText(String mapperClassText) {

        this.mapperClassText = mapperClassText;
    }

    @Override
    public String toString() {
        return "MapClassText{" +
                "mapperClassText='" + mapperClassText + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapperClassText that = (MapperClassText) o;

        return mapperClassText != null ? mapperClassText.equals(that.mapperClassText) : that.mapperClassText == null;
    }

    @Override
    public int hashCode() {
        return mapperClassText != null ? mapperClassText.hashCode() : 0;
    }
}
