package hatemogi.home21

import com.vladsch.flexmark.html.HtmlRenderer
import com.vladsch.flexmark.parser.Parser
import com.vladsch.flexmark.util.ast.Node
import com.vladsch.flexmark.util.data.MutableDataSet

object MarkdownParse extends App {

  val options = new MutableDataSet

  // uncomment to set optional extensions
  //options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create(), StrikethroughExtension.create()));

  // uncomment to convert soft-breaks to hard breaks
  //options.set(HtmlRenderer.SOFT_BREAK, "<br />\n");

  val parser: Parser = Parser.builder(options).build
  val renderer: HtmlRenderer = HtmlRenderer.builder(options).build

  // You can re-use parser and renderer instances
  val document: Node = parser.parse("This is *Sparta*")
  val html: String = renderer.render(document) // "<p>This is <em>Sparta</em></p>\n"
  println(html)

}
