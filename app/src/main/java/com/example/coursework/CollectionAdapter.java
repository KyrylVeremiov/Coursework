//package com.example.coursework;
//
//import android.content.ClipData;
//
//import net.hamnaberg.funclite.Function;
//import net.hamnaberg.funclite.FunctionalList;
//import net.hamnaberg.funclite.Optional;
//import net.hamnaberg.json.parser.CollectionParser;
//
//import org.apache.http.HttpResponse;
//import org.apache.http.client.ResponseHandler;
//import org.apache.http.client.methods.HttpGet;
////import org.apache.http.impl.client.DefaultHttpClient;
//
//import java.util.Collection;
//
//
public class CollectionAdapter {
//    public static void main(String[] args) throws Exception {
//        DefaultHttpClient client = new DefaultHttpClient();
//        Collection collection = client.execute(new HttpGet(URI.create("http://example.com/events")), new CollectionResponseHandler());
//        Optional<Link> alternate = collection.linkByRel("alternate");
//        for (Link link : alternate) {
//            Collection secondCollection = client.execute(new HttpGet(link.getHref()), new CollectionResponseHandler());
//            FunctionalList<SomeType> transformed = FunctionalList.create(secondCollection.getItems()).map(new Function<Item, SomeType>() {
//                @Override
//                public SomeType apply(Item input) {
//                    return new SomeType(input);
//                }
//            });
//
//            System.out.println("transformed = " + transformed);
//        }
//        client.getConnectionManager().shutdown();
//    }
//
//    private static class CollectionResponseHandler implements ResponseHandler<Collection> {
//        @Override
//        public Collection handleResponse(HttpResponse response) throws IOException {
//            if (response.getStatusLine().getStatusCode() == 200) {
//                if (isCollectionJSON(response)) {
//                    InputStream content = null;
//                    try {
//                        content = response.getEntity().getContent();
//                        return new CollectionParser().parse(content);
//                    } finally {
//                        if (content != null) {
//                            content.close();
//                        }
//                    }
//                }
//            }
//            throw new RuntimeException("No usable status here");
//        }
//
//        private boolean isCollectionJSON(HttpResponse response) {
//            return response.getEntity() != null && "application/vnd.collection+json".equals(response.getEntity().getContentType().getValue());
//        }
    }
//
//    private static class SomeType {
//        private final Item item;
//
//        public SomeType(Item input) {
//            item = input;
//        }
//
//        public Optional<String> getName() {
//            return item.propertyByName("name").flatMap(propertyToValueString);
//        }
//
//        private ClipData.Item getItem() {
//            return item;
//        }
//    }
//
//    private static final Function<Value,String> valueStringFunction = new Function<Value, String>() {
//        @Override
//        public String apply(Value input) {
//            return input.asString();
//        }
//    };
//    private static final Function<Property,Optional<String>> propertyToValueString = new Function<Property, Optional<String>>() {
//        @Override
//        public Optional<String> apply(Property input) {
//            return input.getValue().map(valueStringFunction);
//        }
//    };
//
//}
