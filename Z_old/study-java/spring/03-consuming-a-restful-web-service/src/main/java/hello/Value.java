package hello;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Value{
    private Long id;
    private String quote;
    
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
    /**
     * @return the quote
     */
    public String getQuote() {
        return quote;
    }
    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @param quote the quote to set
     */
    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "id="+id+",quote="+quote;
    }
}