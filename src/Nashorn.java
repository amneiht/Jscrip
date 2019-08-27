 import javax.script.ScriptEngine;
    import javax.script.ScriptEngineManager;
    import javax.script.ScriptException;

    public class Nashorn {
        public static void main(String[] args) throws ScriptException {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
            System.out.println(engine.toString());
            long startTime = System.currentTimeMillis();
            engine.eval("var count = 0;for(var i=0;i<100000;i++){count += i}");
            System.out.println("finish " + (System.currentTimeMillis() - startTime));
        }
    }