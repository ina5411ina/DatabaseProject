import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kind.innerMovie
import kind.innerShort
import kind.innerTV

class ParksAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return innerMovie()
            1 -> return innerShort()
            else -> return innerTV()
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence {
        when(position){
            0 -> return "Movie"
            1 -> return "Short"
            else -> return "Tv"

        }
    }

}