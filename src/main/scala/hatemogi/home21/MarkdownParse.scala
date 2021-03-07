package hatemogi.home21

import com.vladsch.flexmark.ext.yaml.front.matter.{AbstractYamlFrontMatterVisitor, YamlFrontMatterExtension}
import com.vladsch.flexmark.html.HtmlRenderer
import com.vladsch.flexmark.parser.Parser
import com.vladsch.flexmark.util.data.{DataKey, MutableDataSet}

import java.util
import scala.jdk.CollectionConverters.MapHasAsScala

object MarkdownParse extends App {

  val options = new MutableDataSet

  options.set(Parser.EXTENSIONS.asInstanceOf[DataKey[Any]], util.Arrays.asList(YamlFrontMatterExtension.create()))
  // uncomment to set optional extensions
  //options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create(), StrikethroughExtension.create()));
  // uncomment to convert soft-breaks to hard breaks
  //options.set(HtmlRenderer.SOFT_BREAK, "<br />\n");

  val parser: Parser = Parser.builder(options).build
  val renderer: HtmlRenderer = HtmlRenderer.builder(options).build

  // You can re-use parser and renderer instances
  val md =
    """
      |---
      |title: The Title
      |tags: [1, 2, 3]
      |---
      |
      |Hello, *World*
      |""".stripMargin
  val document = parser.parse(md)
  val visitor = new AbstractYamlFrontMatterVisitor
  visitor.visit(document)
  println(visitor.getData.asScala)
  val html: String = renderer.render(document) // "<p>This is <em>Sparta</em></p>\n"
  println(html)

}
