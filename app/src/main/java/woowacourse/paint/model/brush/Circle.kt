package woowacourse.paint.model.brush

import android.graphics.Paint
import android.graphics.Path

object Circle : Brush() {
    private var beforePosition = Pair(0f, 0f)
    override fun updateStyle() {
        paintInstance.style = Paint.Style.FILL
    }

    fun setCurrentPosition(xCursor: Float, yCursor: Float) {
        beforePosition = xCursor to yCursor
    }

    fun drawPreview(xCursor: Float, yCursor: Float) {
        val path = Path().apply {
            addCircle(
                beforePosition.first + ((xCursor - beforePosition.first) / 2),
                beforePosition.second + ((xCursor - beforePosition.first) / 2),
                (xCursor - beforePosition.first) / 2,
                Path.Direction.CW,
            )
        }
        val paint = Paint().apply { set(paintInstance) }
        previewDraw = path to paint
    }

    fun draw(xCursor: Float, yCursor: Float) {
        val path = Path().apply {
            addCircle(
                beforePosition.first + ((xCursor - beforePosition.first) / 2),
                beforePosition.second + ((xCursor - beforePosition.first) / 2),
                (xCursor - beforePosition.first) / 2,
                Path.Direction.CW,
            )
        }
        val paint = Paint().apply { set(paintInstance) }
        previousDrawings.add(path to paint)
    }
}
