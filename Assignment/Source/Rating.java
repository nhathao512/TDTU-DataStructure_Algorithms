public class Rating 
{
    private int attr1;
    private int attr2;
    private int attr3;
    private long attr4;

    public Rating(int userId, int movieId, int rating, long timestamps)
    {
        this.attr1 = userId;
        this.attr2 = movieId;
        this.attr3 = rating;
        this.attr4 = timestamps;
    }

    public int getUserId() 
    {
        return this.attr1;
    }

    public int getMovieId() 
    {
        return this.attr2;
    }

    public int getRating() 
    {
        return this.attr3;
    }

    public long getTimestamps() 
    {
        return this.attr4;
    }

    public void setUserId(int userId) 
    {
        this.attr1 = userId;
    }

    public void setMovieId(int movieId) 
    {
        this.attr2 = movieId;
    }

    public void setRating(int rating) 
    {
        this.attr3 = rating;
    }

    public void setTimestamps(long timestamps) 
    {
        this.attr4 = timestamps;
    }

    public String toString()
    {
        return String.format("Rating[%d, %d, %d, %ld]", attr1, attr2, attr3, attr4);
    }
}
