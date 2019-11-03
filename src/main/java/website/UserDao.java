package website;


public class UserDao {
	
	private final static String FILE_NAME = "src/main/resources/userinfo.xml";
	
	
	static public String findUserPassword(int pid){
		if(pid==1) return "12345";
		else{
			throw new IllegalArgumentException("Invalid pid");
		}
		
	}
	/*
    private static class MyEntityResolver extends OXQEntityResolver {
        @Override
        public OXQEntity resolveEntity(OXQEntityKind kind,
                                       OXQEntityLocator locator,
                                       OXQEntityResolverRequestOptions options)
            throws java.io.IOException
        {
            if (kind == OXQEntityKind.DOCUMENT) {
                URI systemId = locator.getSystemIdAsURI();
                if ("file".equals(systemId.getScheme())) {
                    File file = new File(systemId);
                    FileInputStream input = new FileInputStream(file);
                    OXQEntity result = new OXQEntity(input);
                    result.enlistCloseable(input);
                    return result;
                }
            }
            return null;
        }
    }

    static private String runQuery(String query)
        throws javax.xml.xquery.XQException
    {
        XQConnection con = null;
        XQPreparedExpression expr = null;
        XQSequence result = null;
        try {
            OXQDataSource ds = new OXQDataSource();
            con = ds.getConnection();
            OXQView
                .getConnection(con)
                .setEntityResolver(new MyEntityResolver());
            XQStaticContext ctx = con.getStaticContext();
            ctx.setBaseURI(Paths.get("").toUri().toString());
            expr = con.prepareExpression(query, ctx);
            result = expr.executeQuery();
            return result.getSequenceAsString(null);
        } finally {
            if ( result != null ) result.close();
            if ( expr != null ) expr.close();
            if ( con != null ) con.close();
        }
    }*/
	
}
